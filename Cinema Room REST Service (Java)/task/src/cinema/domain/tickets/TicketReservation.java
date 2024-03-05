package cinema.domain.tickets;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketReservation {

    @JsonProperty("token")
    private String uuid;

    @JsonProperty("ticket")
    private Ticket ticket;

    public TicketReservation() {
    }

    public TicketReservation(String uuid, Ticket ticket) {
        this.uuid = uuid;
        this.ticket = ticket;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setSeat(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        if (obj == this) return true;

        TicketReservation ticketReservation = (TicketReservation) obj;
        return this.uuid.equals(ticketReservation.getUuid());
    }
}
