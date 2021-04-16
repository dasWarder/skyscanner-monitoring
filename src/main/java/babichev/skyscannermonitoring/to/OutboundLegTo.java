package babichev.skyscannermonitoring.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;
import java.time.LocalDateTime;

@Data
public class OutboundLegTo {

    @JsonProperty("CarrierId")
    private List<Integer> carrierId;

    @JsonProperty("OriginId")
    private Integer originId;

    @JsonProperty("DestinationId")
    private Integer destinationId;

    @JsonProperty("DepartureDate")
    private String departureDate;
}
