package dev.iwrim.city.exceptions.handler.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {

    private List<String> error;
    private String message;

    public ErrorResponse(List<String> error, String message) {
        this.error = error;
        this.message = message;
    }
}
