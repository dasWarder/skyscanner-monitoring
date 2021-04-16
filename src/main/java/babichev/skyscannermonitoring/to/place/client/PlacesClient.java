package babichev.skyscannermonitoring.to.place.client;

import babichev.skyscannermonitoring.to.place.PlaceTo;

import java.util.*;

public interface PlacesClient {


    List<PlaceTo> getPlaces(String country, String currency, String locale, String query);
}
