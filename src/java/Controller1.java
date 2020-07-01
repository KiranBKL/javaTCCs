/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rgukt
 */
public class Controller1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     boolean status=false;
       
        java.sql.Connection conn = null;
         java.sql.PreparedStatement ps=null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] soid;
        Mytruck db = new Mytruck();
        conn=db.getConnection();
        soid = request.getParameterValues("oid");
        List list = Arrays.asList(soid);
        request.setAttribute("oid", list);
         JFrame f=new JFrame();
          RequestDispatcher rd;
        int i=0,d=0;
         String ss = null;
         int vlll=0;
          ResultSet rs;
             String des="dest";
             out.println(des);
        for(String e:soid)
        {
            try {
                ps=conn.prepareStatement("select destination,convolume from clientorder where oid=?");
                ps.setString(1,e);
                rs = ps.executeQuery();
                rs.next();
                if(i==0)
                {
                    des=rs.getString("destination");
                    out.println(des);
                    vlll=vlll+rs.getInt("convolume");
                }
                else
                {
                     out.println(rs.getString("destination"));
                    if(des == null ? (rs.getString("destination")) == null : des.equals(rs.getString("destination")))
                    {
                        out.println(rs.getString("destination"));
                     vlll=vlll+rs.getInt("convolume");
                    }
                    else
                    {
                        d=1;
                    }
                }
                i=1;
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(Controller1.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(NullPointerException ex){
                 Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(d==1){
                JOptionPane.showMessageDialog(f,"destination should be same");
        }
        if((vlll<500 || vlll>800) && d==0)
        {
            JOptionPane.showMessageDialog(f,"volume sholud be between 500 to 800");              
                d=1;
        }
        if(d==0){
        for(String e: soid){
            try {
                ps=conn.prepareStatement("update clientorder set OrderStatus=? where oid=?");
                ps.setString(1,"assigned");
                ps.setString(2, e);
                
                int z=ps.executeUpdate();
               
              
            }
             catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            JOptionPane.showMessageDialog(f,"ok successfull");
               
            /**
             * Returns a short description of the servlet.
             *
             * @return a String containing servlet description
             */
    }
          rd=request.getRequestDispatcher("Request.jsp");
                rd.include(request,response);

        }
}
    // </editor-fold>


