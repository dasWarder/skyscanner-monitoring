package babichev.skyscannermonitoring.to.client;

import babichev.skyscannermonitoring.to.PlaceTo;

import java.util.*;

public interface PlacesClient {


    List<PlaceTo> getPlaces(String country, String currency, String locale, String query);
}
