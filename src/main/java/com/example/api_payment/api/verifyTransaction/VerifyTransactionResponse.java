
package com.example.api_payment.api.verifyTransaction;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "message",
    "data"
})
@Getter
@Setter
public class VerifyTransactionResponse {
    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private Data data;

}
