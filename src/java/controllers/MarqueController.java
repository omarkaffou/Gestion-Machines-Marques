package controllers;

import beans.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.LogsService;

import services.MarqueService;

@WebServlet(name = "MarqueController", urlPatterns = {"/MarqueController"})
public class MarqueController extends HttpServlet {

    MarqueService marque = new MarqueService();
    LogsService log = new LogsService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        if ("add".equals(request.getParameter("action"))) {
            String username = request.getParameter("username");
            marque.create(new Marque(request.getParameter("code"), request.getParameter("libelle")));
            log.create(new Log(username, "ajouter marque : " + request.getParameter("code")));
            response.setContentType("application/json");
            List<Marque> marques = new ArrayList<>();

            for (Marque p : marque.findAll()) {
                marques.add(new Marque(p.getId(), p.getCode(), p.getLibelle()));

            }
            Gson json = new Gson();
            response.getWriter().write(json.toJson(marques));
        } else if ("update".equals(request.getParameter("action"))) {
            String username = request.getParameter("username");
            log.create(new Log(username, "mise a jour du marque : " + request.getParameter("code")));
            marque.update(new Marque(Integer.parseInt(request.getParameter("id")), request.getParameter("code"), request.getParameter("libelle")));

            response.setContentType("application/json");
            List<Marque> marques = new ArrayList<>();
            for (Marque p : marque.findAll()) {
                marques.add(new Marque(p.getId(), p.getCode(), p.getLibelle()));

            }

            Gson json = new Gson();
            response.getWriter().write(json.toJson(marques));

        } else if ("delete".equals(request.getParameter("action"))) {
            String username = request.getParameter("username");
            marque.deleteMachineParMarque(marque.findById(Integer.parseInt(request.getParameter("id"))));
            log.create(new Log(username, "suppression du marque du code : " + marque.findById(Integer.parseInt(request.getParameter("id"))).getCode()));
            marque.Delete(marque.findById(Integer.parseInt(request.getParameter("id"))));
            response.setContentType("application/json");
            List<Marque> marques = marque.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(marques));
        } else if ("edit".equals(request.getParameter("action"))) {
            response.setContentType("application/json");
            Marque m = marque.findById(Integer.parseInt(request.getParameter("id")));
            Gson json = new Gson();

            response.getWriter().write(json.toJson(m));
        } else {
// findall(response);
            response.setContentType("application/json");
            List<Marque> marques = new ArrayList<>();
            for (Marque p : marque.findAll()) {
                marques.add(new Marque(p.getId(), p.getCode(), p.getLibelle()));

            }

            Gson json = new Gson();
            response.getWriter().write(json.toJson(marques));

        }
    }

    private void findall(HttpServletResponse httpResponse) throws IOException {
        httpResponse.setContentType("application/json");
        List<Marque> marques = marque.findAll();
        Gson json = new Gson();
        httpResponse.getWriter().write(json.toJson(marques));
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
