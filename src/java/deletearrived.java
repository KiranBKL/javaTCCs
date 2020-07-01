/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rgukt
 */
public class deletearrived extends HttpServlet {

  

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    java.sql.Connection conn = null;
     java.sql.PreparedStatement ps=null;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try {
            HttpSession session = request.getSession();
            String id=(String)session.getAttribute("name");
            out.println(id);
            // processRequest(request, response);
            Mytruck db = new Mytruck();
            conn=db.getConnection();
            ps=conn.prepareStatement("delete from clientorder where OrderStatus=? && destination=?");
            ps.setString(1,"assigned");
            ps.setString(2, id);
            
        int z=ps.executeUpdate();
        conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(deletearrived.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
