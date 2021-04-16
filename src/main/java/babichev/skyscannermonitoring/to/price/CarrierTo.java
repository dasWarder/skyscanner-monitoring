package babichev.skyscannermonitoring.to.price;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarrierTo {

    @JsonProperty("CarrierId")
    private Integer carrierId;

    @JsonProperty("Name")
    private String name;
}
