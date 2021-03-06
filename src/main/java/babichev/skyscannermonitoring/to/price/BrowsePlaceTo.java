package babichev.skyscannermonitoring.to.price;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class BrowsePlaceTo {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("PlaceId")
    private String placeId;

    @JsonProperty("IataCode")
    private String iataCode;

    @JsonProperty("SkyscannerCode")
    private String skyscannerCode;

    @JsonProperty("CityName")
    private String cityName;

    @JsonProperty("CityId")
    private String cityId;

    @JsonProperty("CountryName")
    private String countryName;
}
