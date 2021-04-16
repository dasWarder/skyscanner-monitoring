package babichev.skyscannermonitoring.exception.to;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValidationErrorTo {

    @JsonProperty("ParameterName")
    private String parameterName;

    @JsonProperty("ParameterValue")
    private String parameterValue;

    @JsonProperty("Message")
    private String message;
}
