/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltest2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import sun.security.util.PropertyExpander;

/**
 *
 * @author imdadul
 */
public class dbconnector {
    
    private Connection connection;
    private Statement statement;
    private ResultSet result;
   
    
    public dbconnector(){
    }
    
    public Properties loadProperties() throws FileNotFoundException, IOException{
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("E:\\Java\\sqlTest2\\src\\sqltest2\\sql.properties");
        prop.load(ism);
        return prop;
    }
    
    public Connection dbConnection() throws IOException{
        Properties loadProperties = loadProperties();
        String driver = loadProperties.getProperty("MYSQLJDBC.driver");
        String url = loadProperties.getProperty("MYSQLJDBC.url");
        String username = loadProperties.getProperty("MYSQLJDBC.username");
        String password = loadProperties.getProperty("MYSQLJDBC.password");
        
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username, password);

        }catch(Exception ex){
            System.out.println(ex);
        }
        return connection;
    }
    
    public void setQuery() throws IOException{
        Connection dbConnect = dbConnection();
        try{
            statement = dbConnect.createStatement();
            result = statement.executeQuery("Select * from stInfo");
            while (result.next()){
                 System.out.println("ID: "+result.getString("stID") +" FirstName: "+ result.getString("stFirstName") + " LastName: "+ result.getString("stLastName"));
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    
    public void addStudent(String firstName, String lastName, String DOB){
       
     /**
     * @param firstName name of 
     */
     
     String values = "'" +  firstName+"'" +  "," +"'" +   lastName +"'" +  ", '" + DOB + "'";   
     String query = "insert into  stinfo (stFirstName,stLastName,stDOB) values ( " + values + ");";
     try{
     statement.executeUpdate(query);
     }catch (Exception ex){
         System.out.println(ex);
     }
   }
      public void removeStudent(String firstName){
       
     /**
     * @param firstName name of 
     */
     
     String query = "delete from stinfo where stFirstName = '" + firstName + "'; ";
     try{
     statement.executeUpdate(query);
     }catch (Exception ex){
         System.out.println(ex);
     }
   }
    
}
