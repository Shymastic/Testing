/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoalnd.Others;

import khoalnd.Registration_CartObj.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "ShowSearchController", urlPatterns = {"/ShowSearchController"})
public class ShowSearchController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Search Result</h1>");

            String searchValue = request.getParameter("txtSearchValue");

            out.println("Your search value is " + searchValue);

            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");

            if (result != null) {
                out.println("<table border='1'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>No.</th>");
                out.println("<th>Username</th>");
                out.println("<th>Password</th>");
                out.println("<th>LastName</th>");
                out.println("<th>Role</th>");
                out.println("<th>Delete</th>");
                out.println("<th>Update</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                int count = 0;
                for (RegistrationDTO dto : result) {
                    String urlRewriting = "MainController?username=" + dto.getUsername() + "&lastValue=" + request.getParameter("txtSearchValue") +"&btAction=Del";
                    out.println("<form action='MainController'><tr>");
                    out.println("<td>" + ++count + "</td>");
                    out.println("<td>" + "<input type='hidden' name='txtUsername' value='" + dto.getUsername() + "'/>" + dto.getUsername() +"</td>");
                    out.println("<td>" + "<input type='text' name='txtPassword' value='" + dto.getPassword() + "'/></td>");
                    out.println("<td>" + dto.getLastname() + "</td>");
                    if (dto.isRole()) {
                        out.println("<td><input type='checkbox' checked='checked' name='isAdmin'/>" + dto.isRole() + "</td>");
                    } else {
                        out.println("<td><input type='checkbox' name='isAdmin'/>" + dto.isRole() + "</td>");
                    }
                        out.println("<td><a href='" + urlRewriting + "'>Delete</a></td>");
                        out.println("<input type='hidden' name='lastSearchValue' value='" + request.getParameter("txtSearchValue") + "'>");
                        out.println("<td><input type='submit' value='Update' name='btAction'></td>");
                        out.println("</tr></form>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                }
                else{
                out.println("<h2>No record is reached</h2>");
            }
                out.println("</body>");
                out.println("</html>");
            }
            finally{
            out.close();
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
