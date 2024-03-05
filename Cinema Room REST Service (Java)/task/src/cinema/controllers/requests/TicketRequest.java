package cinema.controllers.requests;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TicketRequest {
    private int row;
    private int column;

    @JsonCreator
    public TicketRequest(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
