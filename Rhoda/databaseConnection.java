/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwanza.tukule.version.pkg1.pkg0;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mariwa
 */
public class databaseConnection {
   public static Connection connection(){
       Connection con = null;
       try{
           //test server
          //con = DriverManager.getConnection("jdbc:mysql://194.5.156.94:3306/u843360242_tukule?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","u843360242_tukule","cocaine");
          //real server 
          con = DriverManager.getConnection("jdbc:mysql://41.190.141.49:3306/tukule_kwanza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","tukule","tIlNEYbuBHuhE5hs");
       }catch (SQLException ex) {
            try{
           //test server
          //con = DriverManager.getConnection("jdbc:mysql://194.5.156.94:3306/u843360242_tukule?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","u843360242_tukule","cocaine");
          //real server 
          con = DriverManager.getConnection("jdbc:mysql://kwanzatukule.ddns.net:3306/tukule_kwanza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","kwanzatukule\n" +
"","Mariwa@2020");
       }catch (SQLException x) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       return con;
   } 
}
