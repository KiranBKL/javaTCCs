/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
public class Controller extends HttpServlet {

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
        ResultSet rs=null;
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
        for(String e: soid){
            try {
                ps=conn.prepareStatement("update clientorder set OrderStatus=? where soid=?");
                ps.setString(1,"assigned");
                ps.setString(2, e);
                rs=ps.executeQuery();
                JFrame f=new JFrame();
              JOptionPane.showMessageDialog(f,"ok successfull");
                RequestDispatcher rd=request.getRequestDispatcher("Request.jsp");
                rd.include(request,response);
            }
            /**
             * Returns a short description of the servlet.
             *
             * @return a String containing servlet description
             */ catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


   
    }// </editor-fold>

}
