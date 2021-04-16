package babichev.skyscannermonitoring.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QuoteTo {

    @JsonProperty("QuoteId")
    private Integer quoteId;

    @JsonProperty("minPrice")
    private Integer minPrice;

    @JsonProperty("Direct")
    private Boolean direct;

    @JsonProperty("OutboundLeg")
    private OutboundLegTo outboundLeg;

    @JsonProperty("InboundLeg")
    private OutboundLegTo inboundLeg;

    @JsonProperty("QuoteDateTime")
    private String quoteDateTime;
}
