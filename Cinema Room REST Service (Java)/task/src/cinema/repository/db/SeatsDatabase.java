package cinema.repository.db;

import cinema.domain.seats.Seat;
import cinema.exceptions.TicketPurchaseException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatsDatabase {

    private final int availableRows = 9;

    private final int availableColumns = 9;

    private List<Seat> totalSeats = new ArrayList<>();

    public SeatsDatabase() {
        int cost;

        for (int i = 0; i < availableRows; i++) {
            cost = i <=3 ? 10 : 8;
            for (int j = 0; j < availableColumns; j++) {
                totalSeats.add(new Seat(i + 1, j + 1, cost));
            }
        }
    }

    public int getAvailableRows() {
        return availableRows;
    }

    public int getAvailableColumns() {
        return availableColumns;
    }

    public List<Seat> getTotalSeats() {
        return totalSeats;
    }

    public boolean isSeatFree(int row, int column) {
        Seat seat = filterSeats(row, column);
        return !seat.isOccupied();
    }

    public void releaseSeat(int row, int column) {
        Seat seat = filterSeats(row, column);
        seat.releaseSeat();
    }

    public void occupySeat(int row, int column) {
        Seat seat = filterSeats(row, column);
        seat.occupySeat();
    }

    public int getSeatPrice(int row, int column) {
        return filterSeats(row, column).getPrice();
    }
    public Seat filterSeats(int row, int column) {
        return totalSeats.stream()
                .filter(s -> s.getRow() == row && s.getColumn() == column)
                .findFirst()
                .orElseThrow(() -> new TicketPurchaseException("The number of a row or a column is out of bounds!"));
    }

}
