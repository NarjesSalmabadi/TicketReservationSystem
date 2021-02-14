package servlets;


import model.dao.TicketDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "TicketCancelingServlet")
public class TicketCancelingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        TicketDao ticketDao = new TicketDao();
        boolean answer = ticketDao.deleteTicketWithId(ticketId);
        if (answer == true) {
            request.getRequestDispatcher("/ticketSystem.html").include(request, response);
            writer.println("Your Flight is Canceled!");
        } else if (answer == false) {
            request.getRequestDispatcher("/ticketSystem.html").include(request, response);
            writer.println("No Ticket is found!Try again!");
        }

    }
}
