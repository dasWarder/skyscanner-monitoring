package babichev.skyscannermonitoring.to.currency;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyTo {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Symbol")
    private String symbol;

    @JsonProperty("ThousandsSeparator")
    private String thousandsSeparator;

    @JsonProperty("DecimalSeparator")
    private String decimalSeparator;

    @JsonProperty("SymbolOnLeft")
    private Boolean symbolOnLeft;

    @JsonProperty("SpaceBetweenAmountAndSymbol")
    private Boolean spaceBetweenAmountAndSymbol;

    @JsonProperty("RoundingCoefficient")
    private Integer roundingCoefficient;

    @JsonProperty("DecimalDigits")
    private Integer decimalDigits;
}
