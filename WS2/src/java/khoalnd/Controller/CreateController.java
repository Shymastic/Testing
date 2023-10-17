/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoalnd.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khoalnd.Registration_CartObj.RegistrationDAO;
import khoalnd.Registration_CartObj.RegistrationInsertError;

/**
 *
 * @author admin
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {
    public final String CreateNewAccount = "CreateNewAccount.jsp";
    public final String CreateComplete = "Created.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = CreateNewAccount;
            boolean alert = false;
           String username = request.getParameter("txtUsername");
           String password = request.getParameter("txtPassword");
           String lastname = request.getParameter("txtLastname");
           String confirm = request.getParameter("txtConfirm");
           boolean role = false;
           RegistrationInsertError errors = new RegistrationInsertError();
           if (username.trim().length()< 6 || username.trim().length() > 20){
               errors.setUsernameLengthErr("Username must be 6 - 20 characters");
               alert = true;
           }
           if (password.trim().length() < 6 || password.trim().length() > 30){
               errors.setPasswordLengthErr("Password must be 6 - 30 characters");
               alert = true;
           }
           if (lastname.trim().length() < 2 || lastname.trim().length() > 50){
               errors.setLastNameLengthErr("Last name must be 2 - 50 characters");
               alert = true;
           }
           if(!password.trim().equals(confirm.trim())){
               errors.setConfirmNotMatch("Confirm password not matched");
               alert = true;
           }
           RegistrationDAO dao = new RegistrationDAO();
           if(!alert){
           boolean result = dao.insertRecord(username, password, lastname, role);
           if(result){
               url= CreateComplete;
        }
           else {
               errors.setUsernameIsExisted("Username had existed!");
               request.setAttribute("INSERTERROR", errors);
           }
           }
           response.sendRedirect(url);
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
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

