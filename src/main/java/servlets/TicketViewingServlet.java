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

@WebServlet(name = "TicketViewingServlet")
public class TicketViewingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int ticketId=Integer.parseInt(request.getParameter("ticketId"));
        TicketDao ticketDao = new TicketDao();
            Ticket ticket = ticketDao.getTicket(ticketId);
            if (ticket!=null) {
                request.getRequestDispatcher("/ticketSystem.html").include(request, response);
                writer.println(ticket);
            } else if(ticket==null) {
                request.getRequestDispatcher("/ticketSystem.html").include(request, response);
                writer.println("No Ticket is found!Try again!");
            }

    }
    }

