package babichev.skyscannermonitoring.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryTo {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Name")
    private String name;

}
