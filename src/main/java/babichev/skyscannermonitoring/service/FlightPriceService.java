package babichev.skyscannermonitoring.service;

import babichev.skyscannermonitoring.entity.Subscription;
import babichev.skyscannermonitoring.to.price.FlightPriceTo;

public interface FlightPriceService {

    Integer findMinPrice(FlightPriceTo flightPriceTo);

    FlightPriceTo findFlightPrice(Subscription subscription);
}
