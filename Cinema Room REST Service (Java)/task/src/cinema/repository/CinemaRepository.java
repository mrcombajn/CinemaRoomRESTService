package cinema.repository;

import cinema.beans.Seat;
import cinema.utils.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaRepository {

    @JsonProperty("total_rows")
    int availableRows = 9;

    @JsonProperty("total_columns")
    int availableColumns = 9;

    @JsonProperty("available_seats")
    List<Seat> totalSeats;

    public CinemaRepository() {
        totalSeats = new ArrayList<>();

        for (int i = 0; i < availableRows; i++) {
            for (int j = 0; j < availableRows; j++) {
                int cost = ;
                totalSeats.add(new Seat(i + 1, j + 1, ));
            }
        }
    }

    public int getAvailableRows() {
        return availableRows;
    }

    public void setAvailableRows(int availableRows) {
        this.availableRows = availableRows;
    }

    public int getAvailableColumns() {
        return availableColumns;
    }

    public void setAvailableColumns(int availableColumns) {
        this.availableColumns = availableColumns;
    }

    public List<Seat> getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(List<Seat> totalSeats) {
        this.totalSeats = totalSeats;
    }
}
