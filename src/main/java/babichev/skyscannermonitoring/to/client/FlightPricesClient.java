package babichev.skyscannermonitoring.to.client;

import babichev.skyscannermonitoring.to.FlightPriceTo;

public interface FlightPricesClient {

    FlightPriceTo browseQuotes(String country, String currency, String locale, String originalplace,
                               String destinationplace, String outboundpartialdate);

    FlightPriceTo browseQuotes(String country, String currency, String locale, String originPlace,
                                 String destinationPlace, String outboundPartialDate, String inboundPartialDate);
}
