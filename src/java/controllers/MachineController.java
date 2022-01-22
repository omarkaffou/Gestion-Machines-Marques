package controllers;

import beans.Chart;
import beans.Log;
import beans.Machine;
import beans.Marque;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.MachineService;
import services.LogsService;
import services.MarqueService;

@WebServlet(name = "MachineController", urlPatterns = {"/MachineController"})
public class MachineController extends HttpServlet {

    MarqueService marque = new MarqueService();
    MachineService machine = new MachineService();
    LogsService log = new LogsService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ("add".equals(request.getParameter("action"))) {
            String username = request.getParameter("username");
            log.create(new Log(username, "ajouter machine : " + request.getParameter("reference")));
            machine.create(new Machine(request.getParameter("reference"), new Date(request.getParameter("date").replace("-", "/")), Integer.parseInt(request.getParameter("prix")), Integer.parseInt(request.getParameter("marque"))));

            response.setContentType("application/json");

            List<Machine> machines = machine.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(machines));

        } else if ("update".equals(request.getParameter("action"))) {
            String username = request.getParameter("username");
            log.create(new Log(username, "mise a jour du machine : " + request.getParameter("reference")));
            machine.update(new Machine(Integer.parseInt(request.getParameter("id")), request.getParameter("reference"), Integer.parseInt(request.getParameter("prix"))));

            response.setContentType("application/json");

            List<Machine> machines = machine.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(machines));

        } else if ("delete".equals(request.getParameter("action"))) {
            String username = request.getParameter("username");
            log.create(new Log(username, "supprimer du machine : " + request.getParameter("reference")));
            machine.Delete(machine.findById(Integer.parseInt(request.getParameter("id"))));
            response.setContentType("application/json");
            List<Machine> machines = machine.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(machines));
        } else if ("edit".equals(request.getParameter("action"))) {
            response.setContentType("application/json");
            Machine m = machine.findById(Integer.parseInt(request.getParameter("id")));
            Gson json = new Gson();

            response.getWriter().write(json.toJson(m));
        } else if ("search".equals(request.getParameter("action"))) {

            response.setContentType("application/json");
            List<Machine> machines = new ArrayList<>();
            for (Machine p : machine.machineParMarque(Integer.parseInt(request.getParameter("id")))) {
                machines.add(new Machine(p.getId(), p.getReference(), p.getDateAchat(), p.getPrix(), p.findLibelle()));

            }
            Gson json = new Gson();
            response.getWriter().write(json.toJson(machines));
        } else if ("searchByDate".equals(request.getParameter("action"))) {

            response.setContentType("application/json");
            List<Machine> machines = new ArrayList<>();
            for (Machine p : machine.findBetweenDate(new Date(request.getParameter("date1").replace("-", "/")), new Date(request.getParameter("date2").replace("-", "/")))) {
                machines.add(new Machine(p.getId(), p.getReference(), p.getDateAchat(), p.getPrix(), p.findLibelle()));
            }
            Gson json = new Gson();
            response.getWriter().write(json.toJson(machines));
        } else if ("listeNombreParMachineParMarque".equals(request.getParameter("action"))) {
            response.setContentType("application/json");
            List<Chart> dataTheChart = machine.nombreDeMachineParMarque();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(dataTheChart));
        } else {

            response.setContentType("application/json");

            List<Machine> machines = new ArrayList<>();
            for (Machine p : machine.findAll()) {
                machines.add(new Machine(p.getId(), p.getReference(), p.getDateAchat(), p.getPrix(), p.findLibelle()));

            }

            Gson json = new Gson();
            response.getWriter().write(json.toJson(machines));
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
