package cinema.repository;

import cinema.domain.tickets.Ticket;
import cinema.domain.tickets.TicketReservation;
import cinema.exceptions.TicketPurchaseException;
import cinema.repository.db.SeatsDatabase;
import cinema.repository.helpers.TicketTokenHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CinemaRepository {

    private final SeatsDatabase seatsDatabase;

    @JsonIgnore
    List<TicketReservation> activeReservations = new ArrayList<>();

    @Autowired
    public CinemaRepository(SeatsDatabase seatsDatabase) {
        this.seatsDatabase = seatsDatabase;
    }

    public Map<String, Object> getAllSeats() {
        Map<String, Object> seatDatabase = new HashMap<>();
        seatDatabase.put("rows", seatsDatabase.getAvailableRows());
        seatDatabase.put("columns", seatsDatabase.getAvailableColumns());
        seatDatabase.put("seats", seatsDatabase.getTotalSeats());
        return seatDatabase;
    }

    public boolean isSeatFree(int row, int column) {
        return seatsDatabase.isSeatFree(row, column);
    }

    public int getSeatPrice(int row, int column) {
        return  seatsDatabase.getSeatPrice(row, column);
    }

    public TicketReservation filterActiveReservations(String UUID) {
        return activeReservations.stream()
                .filter(r -> r.getUuid().equals(UUID))
                .findFirst()
                .orElseThrow(() -> new TicketPurchaseException("Wrong token!"));
    }

    public Integer calculateIncome() {
        return activeReservations
                .stream()
                .map(tr -> tr.getTicket().getCost())
                .reduce(0, Integer::sum);
    }

    public void releaseSeat(TicketReservation ticketReservation) {
        seatsDatabase.releaseSeat(ticketReservation.getTicket().getRow(), ticketReservation.getTicket().getColumn());
    }

    public void addTicketReservation(TicketReservation ticketReservation) {
        activeReservations.add(ticketReservation);
    }

    public void removeTicketReservation(TicketReservation ticketReservation) {
        activeReservations.remove(ticketReservation);
    }

    public void occupySeat(TicketReservation reservation) {
        seatsDatabase.occupySeat(reservation.getTicket().getRow(), reservation.getTicket().getColumn());
    }

    public Integer getPurchasedTicketsCount() {
        return activeReservations.size();
    }

    public Integer getAvailableSeats() {
        return seatsDatabase.getTotalSeats().size() - activeReservations.size();
    }

}
