package servlets;


import model.dao.TicketDao;
import model.entity.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TicketEditingServlet")
public class TicketEditingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        String fullName = request.getParameter("fullName");
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");
        int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));

        TicketDao ticketDao = new TicketDao();
        Ticket ticket = new Ticket(ticketId, fullName, origin, destination, departureDate, flightNumber);
        boolean answer = ticketDao.updateTicket(ticketId, ticket);
        if (answer == true) {
            request.getRequestDispatcher("/ticketSystem.html").include(request, response);
            writer.println(" Your Ticket is updated successfully!");
        } else if (answer == false) {
            request.getRequestDispatcher("/ticketSystem.html").include(request, response);
            writer.println(" Your Ticket is not found!");
        }
    }
}
