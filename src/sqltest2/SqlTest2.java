/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltest2;

import java.io.IOException;

/**
 *
 * @author imdadul
 */
public class SqlTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        dbconnector ab= new dbconnector();
        ab.setQuery();
        ab.removeStudent("Ayana");
        System.out.println("=================================");
        ab.setQuery();
    }
    
}
