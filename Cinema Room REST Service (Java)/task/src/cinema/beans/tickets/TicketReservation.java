package cinema.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketReservation {

    @JsonProperty("token")
    private String uuid;

    @JsonProperty("ticket")
    private Ticket seat;

    public TicketReservation() {
    }

    public TicketReservation(String uuid, Ticket seat) {
        this.uuid = uuid;
        this.seat = seat;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Ticket getSeat() {
        return seat;
    }

    public void setSeat(Ticket seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        if (obj == this) return true;

        TicketReservation ticketReservation = (TicketReservation) obj;
        return this.uuid.equals(ticketReservation.getUuid());
    }
}
