/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.Constant;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author HelloThang
 */
public class Backup extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String app = request.getParameter("app");
            String token = request.getParameter("token");
            String backlink = null;
            String url = null;
            out.print(token + "   ");
            switch (app) {
                case "main":
                    url = Constant.LOCAL_MAIN;
                    backlink = "./main.jsp";
                    break;
                case "backend":
                    url = Constant.LOCAL_BACKEND;
                    backlink = "./backend.jsp";

                    break;
                case "buzz":
                    url = Constant.LOCAL_BUZZ;
                    backlink = "./buzz.jsp";

                    break;
                case "chat":
                    url = Constant.LOCAL_CHAT;
                    backlink = "./chat.jsp";

                    break;
                case "JPNS":
                    url = Constant.LOCAL_JPNS;
                    backlink = "./JPNS.jsp";

                    break;
                case "meet":
                    url = Constant.LOCAL_MEET;
                    backlink = "./meet.jsp";

                    break;
                case "stf":
                    url = Constant.LOCAL_STF;
                    backlink = "./stf.jsp";

                    break;
                case "ums":
                    url = Constant.LOCAL_UMS;
                    backlink = "./ums.jsp";

                    break;
            }
            JSONObject js = new JSONObject();
            try {
                js.put("app", app);
                js.put("api", "reset_config");
                js.put("backup", "true");
                SendAPI send = new SendAPI();
                if (!send.checkToken(token)) {
                    response.sendRedirect("./index.jsp");
                    return;
                }
                send.SaveWorkFlow(url, js);
            } catch (JSONException ex) {
                Logger.getLogger(UpdateProperties.class.getName()).log(Level.SEVERE, null, ex);
                out.println(ex.getMessage());
            }
            response.sendRedirect(backlink);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
