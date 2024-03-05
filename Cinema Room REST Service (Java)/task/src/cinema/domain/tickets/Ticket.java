package cinema.domain.tickets;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {

    private int row;
    private int column;

    @JsonProperty("price")
    private int cost;

    public Ticket() {
    }

    public Ticket(int row, int column, int cost) {
        this.row = row;
        this.column = column;
        this.cost = cost;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
