package model.entity;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String passengerName;
    private String origin;
    private String destination;
    private String departureDate;
    private Integer flightNumber;

    public Ticket(Integer ticketId, String passengerFullName, String origin, String destination, String departureDate, Integer flightNumber) {
        this.id = ticketId;
        this.passengerName = passengerFullName;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.flightNumber = flightNumber;
    }

    public Ticket(String passengerFullName, String origin, String destination, String departureDate, Integer flightNumber) {
        this.passengerName = passengerFullName;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.flightNumber = flightNumber;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int ticketId) {
        this.id = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerFullName) {
        this.passengerName = passengerFullName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + id +
                ", passengerFullName='" + passengerName + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", flightNumber=" + flightNumber +
                '}';
    }
}
