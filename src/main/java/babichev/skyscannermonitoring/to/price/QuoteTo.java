package babichev.skyscannermonitoring.to.price;

import babichev.skyscannermonitoring.to.price.OutboundLegTo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


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
