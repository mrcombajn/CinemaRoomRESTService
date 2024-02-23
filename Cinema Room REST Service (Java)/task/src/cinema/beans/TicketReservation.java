package cinema.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SeatToken {

    @JsonProperty("token")
    private String UUID;

    @JsonProperty("ticket")
    private Seat seat;

    public SeatToken() {
    }

    public SeatToken(String UUID, Seat seat) {
        this.UUID = UUID;
        this.seat = seat;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
