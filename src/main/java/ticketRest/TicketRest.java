package ticketRest;

import model.dao.TicketDao;
import model.entity.Ticket;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/tickets")
public class TicketRest {
    TicketDao ticketDao = new TicketDao();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTicket(Ticket ticket) {
        int id = ticketDao.insertTicketIntoDB(ticket);
        return Response.status(200).entity("New ticket with id=" + id + " is created.").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getAllTickets() {
        List<Ticket> ticketList = ticketDao.viewTickets();
        return ticketList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket getTicket(@PathParam("id") int i) {
        Ticket ticket = ticketDao.getTicket(i);
        return ticket;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTicket(@PathParam("id") int i, Ticket ticket) {
        ticketDao.updateTicket(i, ticket);
        return Response.status(200).entity("Ticket with id= "+ i + " is updated.").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTicket(@PathParam("id") int i) {
        boolean answer = ticketDao.deleteTicketWithId(i);
        if(answer==true){
            return Response.status(200).entity("Ticket " + i + " deleted.").build();
        }
        else if(answer==false){
            return Response.status(200).entity("Ticket is not found!").build();
        }
        return null;
    }

    @DELETE
    public Response deleteTickets() {
        ticketDao.deleteTickets();
        return Response.status(200).entity("All tickets are deleted.").build();
    }

}
