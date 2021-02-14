package model.dao;

import model.DatabaseConnection;
import model.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class TicketDao {

    public int insertTicketIntoDB(Ticket ticket) {
        Session session = DatabaseConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(ticket);
        transaction.commit();
        session.close();
        return ticket.getId();
    }

    public List<Ticket> viewTickets() {
        Session session = DatabaseConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select ticket from model.entity.Ticket ticket");
        List<Ticket> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public Ticket getTicket(int i) {
        Session session = DatabaseConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, i);
        session.getTransaction().commit();
        session.close();
        return ticket;
    }

    public boolean updateTicket(int i, Ticket ticket) {
        Session session = DatabaseConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Ticket ticketFromDB = session.get(Ticket.class, i);
        if (Objects.nonNull(ticketFromDB)) {
            ticketFromDB.setDepartureDate(ticket.getDepartureDate());
            ticketFromDB.setDestination(ticket.getDestination());
            ticketFromDB.setFlightNumber(ticket.getFlightNumber());
            ticketFromDB.setOrigin(ticket.getOrigin());
            ticketFromDB.setPassengerName(ticket.getPassengerName());
            session.update(ticketFromDB);
            session.getTransaction().commit();
            session.close();
            return true;
        }else{
            session.getTransaction().commit();
            session.close();
            return false;
        }
    }

    public boolean deleteTicketWithId(int i) {
        Session session = DatabaseConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, i);
        if (Objects.nonNull(ticket)) {
            session.remove(ticket);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().commit();
        session.close();
        return false;
    }

    public void deleteTickets() {
        Session session = DatabaseConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select ticket from model.entity.Ticket ticket");
        List<Ticket> list = query.list();
        for (Ticket ticket : list) {
            session.delete(ticket);
        }
        session.getTransaction().commit();
        session.close();
    }
}
