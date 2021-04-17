package babichev.skyscannermonitoring.to.price.client;

import babichev.skyscannermonitoring.exception.FlightClientException;
import babichev.skyscannermonitoring.exception.to.ValidationErrorTo;
import babichev.skyscannermonitoring.service.UniRestService;
import babichev.skyscannermonitoring.to.currency.CurrencyTo;
import babichev.skyscannermonitoring.to.price.BrowsePlaceTo;
import babichev.skyscannermonitoring.to.price.CarrierTo;
import babichev.skyscannermonitoring.to.price.FlightPriceTo;
import babichev.skyscannermonitoring.to.price.QuoteTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import static babichev.skyscannermonitoring.service.UniRestServiceImpl.*;

public class FlightPricesClientImpl implements FlightPricesClient {

    private UniRestService restService;

    private ObjectMapper objectMapper;

    @Autowired
    public FlightPricesClientImpl(UniRestService restService, ObjectMapper objectMapper) {
        this.restService = restService;
        this.objectMapper = objectMapper;
    }

    @Override
    public FlightPriceTo browseQuotes(String country, String currency, String locale, String originalplace, String destinationplace, String outboundpartialdate) {
        HttpResponse<JsonNode> response = restService.get(String.format(BROWSE_PLACES_FORMAT, country, currency, locale,
                originalplace, destinationplace, outboundpartialdate));

       return mapToObject(response);
    }

    @Override
    public FlightPriceTo browseQuotes(String country, String currency, String locale, String originPlace, String destinationPlace, String outboundPartialDate, String inboundPartialDate) {
        HttpResponse<JsonNode> response = restService.get(String.format(BROWSE_PLACES_WITH_OPTIONAL_PARAM_FORMAT, country, currency,
                locale, originPlace, destinationPlace, outboundPartialDate, inboundPartialDate));

        return mapToObject(response);
    }

    private FlightPriceTo mapToObject(HttpResponse<JsonNode> response) {
        if(response.getStatus() == HttpStatus.SC_OK) {
            FlightPriceTo flightPriceTo = new FlightPriceTo();

            String quotesAsString = getResultAsString(response, QUOTES_KEY);
            flightPriceTo.setQuotes(readValue(quotesAsString, new TypeReference<List<QuoteTo>>(){
            }));

            String carriersAsString = getResultAsString(response, CARRIER_KEY);
            flightPriceTo.setCarriers(readValue(carriersAsString, new TypeReference<List<CarrierTo>>() {
            }));

            String placesAsString = getResultAsString(response, PLACES_KEY);
            flightPriceTo.setPlaces(readValue(placesAsString, new TypeReference<List<BrowsePlaceTo>>() {
            }));

            String currenciesAsString = getResultAsString(response, CURRENCIES_KEY);
            flightPriceTo.setCurrencies(readValue(currenciesAsString, new TypeReference<List<CurrencyTo>>() {
            }));
        }

        throw new FlightClientException(String.format("There are validation errors. statusCode = %s",
                readValue(getResultAsString(response, VALIDATIONS_KEY), new TypeReference<List<ValidationErrorTo>>() {
                })));
    }

    private <T> List<T> readValue(String resultAsString, TypeReference<List<T>> valueTypeRef) {
        List<T> listTos;

        try {
            listTos = objectMapper.readValue(resultAsString, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new FlightClientException("Object Mapping failure.", e);
        }

        return listTos;
    }

    private String getResultAsString(HttpResponse<JsonNode> response, String key) {
        return response.getBody()
                .getObject()
                .get(key)
                .toString();
    }
}
