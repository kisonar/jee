/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.client.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mossad.irp.interfaces.task.helper.IServiceTaskHelperLocal;
import com.mossad.irp.interfaces.task.IServiceTaskLocal;
import com.mossad.irp.interfaces.user.IServiceUserLocal;
import com.mossad.jpa.lib.domain.abstraction.AbstractEntity;
import com.mossad.jpa.lib.domain.task.Task;
import com.mossad.jpa.lib.domain.task.TaskPriority;
import com.mossad.jpa.lib.domain.task.TaskStatus;
import com.mossad.jpa.lib.domain.task.TaskType;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author mmigdal
 */
@WebServlet(name = "ServletMossadAdmin", urlPatterns = {"/ServletMossadAdmin"})
public class ServletMossadAdmin extends HttpServlet {

    private UserTableBuilder userTableBuilder = new UserTableBuilder();
    private static final long serialVersionUID = 1L;
    //@EJB
    //private IServiceUserLocal serviceUser;
    //@EJB
    //private IServiceTaskLocal serviceTask;
    //@EJB
    //private IServiceTaskHelperLocal serviceTaskHelper;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMossad</title>");
            out.println("</head>");
            out.println("<body>");

            
            /*
            userTableBuilder.printTableWithUsers(out, serviceUser.getUsers());

            List<AbstractEntity> commitDispalyCollection = new ArrayList<>();
            commitDispalyCollection.addAll(serviceTaskHelper.getTaskPriorities());           
            userTableBuilder.printTableWithEntries(out, "Priorities", commitDispalyCollection);

         
            commitDispalyCollection.clear();
            commitDispalyCollection.addAll(serviceTaskHelper.getTaskStatuses());
            userTableBuilder.printTableWithEntries(out, "Task Statuses", commitDispalyCollection);

            commitDispalyCollection.clear();
            commitDispalyCollection.addAll(serviceTaskHelper.getTaskTypes());
            userTableBuilder.printTableWithEntries(out, "Task types", commitDispalyCollection);

            
            List<Task> tasks = serviceTask.getTasks();
            
            for (Task task : tasks) {
                System.out.println(task.getId());
                System.out.println(task.getTitle());
                System.out.println(task.getPriority());
                System.out.println(task.getStatus());
                System.out.println(task.getType());
            }
            */    
            out.println("</body>");
            out.println("</html>");

       


        }
        catch (Exception e){
            
           String error =  e.getLocalizedMessage();
            
        }
        
        
        finally {
            out.flush();
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
        return "Servlet monitoring Mossad entries in DB";
    }// </editor-fold>
}
