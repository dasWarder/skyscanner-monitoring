package babichev.skyscannermonitoring.to.place.client;

import babichev.skyscannermonitoring.service.UniRestService;
import babichev.skyscannermonitoring.to.place.PlaceTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static babichev.skyscannermonitoring.service.UniRestServiceImpl.*;

@Component
public class PlacesClientImpl implements PlacesClient {

    private UniRestService restService;

    private ObjectMapper objectMapper;

    @Autowired
    public PlacesClientImpl(UniRestService restService, ObjectMapper objectMapper) {
        this.restService = restService;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<PlaceTo> getPlaces(String country, String currency, String locale, String query) {
        HttpResponse<JsonNode> response = restService.get(String.format(PLACES_FORMAT, country, currency, locale, query));

        if(response.getStatus() != HttpStatus.SC_OK) {
            return null;
        }

        String jsonList = response.getBody()
                .getObject()
                .get(PLACES_KEY)
                .toString();

        List<PlaceTo> placeTos = new ArrayList<>();

        try {
            placeTos = objectMapper.readValue(jsonList, new TypeReference<List<PlaceTo>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return placeTos;
    }
}
