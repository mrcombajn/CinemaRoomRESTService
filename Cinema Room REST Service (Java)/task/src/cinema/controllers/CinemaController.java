package cinema.controllers;

import cinema.controllers.requests.ReturnRequest;
import cinema.controllers.requests.TicketRequest;
import cinema.domain.tickets.Ticket;
import cinema.domain.tickets.TicketReservation;
import cinema.service.CinemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    ResponseEntity<Map<String, Object>> getAvailableSeats() {
        return ResponseEntity
                .ok(cinemaService.getSeats());
    }

    @GetMapping("/stats")
    ResponseEntity<Object> getCinemaStats(@RequestParam Optional<String> password) {
        return ResponseEntity
                .ok(cinemaService.getStats(password));
    }

    @PostMapping(value = "/purchase", consumes = "application/json", produces = "application/json")
    ResponseEntity<TicketReservation> purchaseTicket(@RequestBody TicketRequest ticketRequest) {
        return ResponseEntity
                .ok(cinemaService.purchaseTicket(ticketRequest));
    }

    @PostMapping(value = "/return", consumes = "application/json", produces = "application/json")
    ResponseEntity<Map<String, Ticket>> returnTicket(@RequestBody ReturnRequest returnRequest) {
        return ResponseEntity
                .ok(cinemaService.returnTicket(returnRequest));
    }

}
