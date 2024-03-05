package cinema.controllers.requests;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ReturnRequest {

    private String token;

    @JsonCreator
    public ReturnRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
