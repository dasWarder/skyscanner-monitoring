package babichev.skyscannermonitoring.to.price.client;

import babichev.skyscannermonitoring.to.price.FlightPriceTo;

public interface FlightPricesClient {

    FlightPriceTo browseQuotes(String country, String currency, String locale, String originalplace,
                               String destinationplace, String outboundpartialdate);

    FlightPriceTo browseQuotes(String country, String currency, String locale, String originPlace,
                                 String destinationPlace, String outboundPartialDate, String inboundPartialDate);
}
