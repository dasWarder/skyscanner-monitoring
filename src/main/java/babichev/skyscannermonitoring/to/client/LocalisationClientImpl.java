package babichev.skyscannermonitoring.to.client;

import babichev.skyscannermonitoring.service.UniRestService;
import babichev.skyscannermonitoring.to.CountryTo;
import babichev.skyscannermonitoring.to.CurrencyTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static babichev.skyscannermonitoring.service.UniRestServiceImpl.*;

@Component
public class LocalisationClientImpl implements LocalisationClient {

    private UniRestService restService;


    private ObjectMapper objectMapper;

    @Autowired
    public LocalisationClientImpl(UniRestService restService, ObjectMapper objectMapper) {
        this.restService = restService;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<CountryTo> getCountries(String locale) {
        HttpResponse<JsonNode> response = restService.get(String.format(COUNTRIES_FORMAT, locale));

        if(response.getStatus() != HttpStatus.SC_OK) {
            return null;
        }

        String jsonList = response.getBody()
                .getObject()
                .get(COUNTRIES_KEY)
                .toString();

        List<CountryTo> countryTos = new ArrayList<>();

        try {
            countryTos = objectMapper.readValue(jsonList, new TypeReference<List<CountryTo>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return countryTos;
    }

    @Override
    public List<CurrencyTo> getCurrencies() {
        HttpResponse<JsonNode> response = restService.get(CURRENCIES_FORMAT);

        if(response.getStatus() != HttpStatus.SC_OK) {
            return null;
        }

        String jsonList = response.getBody()
                .getObject()
                .get(CURRENCIES_KEY)
                .toString();

        List<CurrencyTo> currencyTos = new ArrayList<>();

        try {
            currencyTos = objectMapper.readValue(jsonList, new TypeReference<List<CurrencyTo>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return currencyTos;
    }
}
