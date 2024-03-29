
package com.example.api_payment.api.verifyTransaction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "start_time",
    "time_spent",
    "attempts",
    "errors",
    "success",
    "mobile",
    "input",
    "history"
})
@Getter
@Setter
public class Log {

    @JsonProperty("start_time")
    private Integer startTime;
    @JsonProperty("time_spent")
    private Integer timeSpent;
    @JsonProperty("attempts")
    private Integer attempts;
    @JsonProperty("errors")
    private Integer errors;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("mobile")
    private Boolean mobile;
    @JsonProperty("input")
    private List<Object> input = new ArrayList<Object>();
    @JsonProperty("history")
    private List<History> history = new ArrayList<History>();

}
