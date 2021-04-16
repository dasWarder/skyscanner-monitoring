package babichev.skyscannermonitoring.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.*;

@Data
public class FlightPriceTo {

    @JsonProperty("Quotes")
    private List<QuoteTo> quotes;

    @JsonProperty("Carriers")
    private List<CarrierTo> carriers;

    @JsonProperty("Places")
    private List<BrowsePlaceTo> places;

    @JsonProperty("Currencies")
    private List<CurrencyTo> currencies;

}
