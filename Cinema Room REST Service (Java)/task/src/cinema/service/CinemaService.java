package cinema.service;

import cinema.controllers.requests.ReturnRequest;
import cinema.controllers.requests.TicketRequest;
import cinema.domain.tickets.Ticket;
import cinema.domain.tickets.TicketReservation;
import cinema.exceptions.IncorrectPasswordException;
import cinema.exceptions.TicketPurchaseException;
import cinema.repository.CinemaRepository;
import cinema.repository.helpers.TicketTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    private final String secret = "super_secret";

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Map<String, Object> getSeats() {
        return cinemaRepository.getAllSeats();
    }

    public TicketReservation purchaseTicket(TicketRequest ticketRequest) {
        if (!cinemaRepository.isSeatFree(ticketRequest.getRow(), ticketRequest.getColumn()))
            throw new TicketPurchaseException("The ticket has been already purchased!");

        Ticket ticket = new Ticket(ticketRequest.getRow(), ticketRequest.getColumn(), cinemaRepository.getSeatPrice(ticketRequest.getRow(), ticketRequest.getColumn()));

        TicketReservation reservation = new TicketReservation(TicketTokenHelper.createToken(), ticket);
        cinemaRepository.addTicketReservation(reservation);
        cinemaRepository.occupySeat(reservation);
        return reservation;
    }

    public Map<String, Ticket> returnTicket(ReturnRequest returnRequest) {
        TicketReservation ticketReservation = cinemaRepository.filterActiveReservations(returnRequest.getToken());

        cinemaRepository.removeTicketReservation(ticketReservation);
        cinemaRepository.releaseSeat(ticketReservation);
        return Map.of("ticket", ticketReservation.getTicket());
    }

    public Map<String, Integer> getStats(Optional<String> password) {
        password.stream()
                .filter(d -> d.equals(secret))
                .findFirst()
                .orElseThrow(() -> new IncorrectPasswordException("The password is wrong!"));

        Map<String, Integer> cinemaStats = new HashMap<>();
        cinemaStats.put("income", cinemaRepository.calculateIncome());
        cinemaStats.put("available", cinemaRepository.getAvailableSeats());
        cinemaStats.put("purchased", cinemaRepository.getPurchasedTicketsCount());

        return cinemaStats;
    }
}
