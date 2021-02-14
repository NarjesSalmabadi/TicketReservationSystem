package servlets;

import model.dao.TicketDao;
import model.entity.Ticket;
import org.glassfish.jersey.server.JSONP;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TicketBookingServlet")
public class TicketBookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String fullName = request.getParameter("fullName");
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");
        int flightNumber = Integer.parseInt(request.getParameter("flightNumber"));

        TicketDao ticketDao = new TicketDao();

        Ticket ticket = new Ticket(fullName, origin, destination, departureDate, flightNumber);
        int ticketId = ticketDao.insertTicketIntoDB(ticket);
        request.getRequestDispatcher("/ticketSystem.html").include(request, response);
        writer.println("Your ticket has been successfully registered! Your ticket Id is " + ticketId);
    }
}
