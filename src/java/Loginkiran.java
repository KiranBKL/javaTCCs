
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rgukt
 */
public class Loginkiran {
    public static boolean validate(String name,String pass)
    {
        boolean status=false;
        ResultSet rs=null;
        java.sql.Connection conn = null;
         java.sql.PreparedStatement ps=null;
        try {
             Mytruck db = new Mytruck();
            conn=db.getConnection();
           ps=conn.prepareStatement("select user,password from Client where user=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            status =rs.next();
          
        } catch (SQLException ex) {
            Logger.getLogger(Loginkiran.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn!=null)
            {
               try{
                   conn.close();
               } catch (SQLException ex) {
                    Logger.getLogger(Loginkiran.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
            if(ps!=null)
            {
                try{
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Loginkiran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null)
            {
                try{
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Loginkiran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
        }
          return status; 
    }
    
}
