package cinema.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {

    private int row;
    private int column;

    @JsonProperty("price")
    private int cost;

    @JsonIgnore
    private boolean taken;

    public Seat() {
    }

    public Seat(int row, int column, int cost) {
        this.row = row;
        this.column = column;
        this.cost = cost;
        this.taken = false;
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

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public boolean isTaken() {
        return taken;
    }

}
