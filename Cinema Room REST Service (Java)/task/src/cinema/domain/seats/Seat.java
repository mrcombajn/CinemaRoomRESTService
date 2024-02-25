package cinema.beans.seats;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {

    private int row;

    private int column;

    private int price;

    @JsonIgnore
    private boolean occupied;

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.occupied = false;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void releaseSeat() {
        this.occupied = false;
    }

    public void occupySeat() {
        this.occupied = true;
    }
}
