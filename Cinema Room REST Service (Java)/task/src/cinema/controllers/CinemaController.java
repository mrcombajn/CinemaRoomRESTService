package cinema.controllers;

import cinema.repository.CinemaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    CinemaRepository repository;

    @Autowired
    public CinemaController(CinemaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/seats")
    String getAvailableSeats() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(repository);
    }

    @PostMapping("/purchase")
    String purchaseTicket(@PathVariable int row, @PathVariable int column) {
        return null;
    }
}
