package cinema.repository.helpers;

import java.util.UUID;

public class TicketTokenHelper {

    public static String createToken() {
        return UUID.randomUUID().toString();
    }
}
