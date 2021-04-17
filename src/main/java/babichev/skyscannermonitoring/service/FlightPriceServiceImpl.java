package babichev.skyscannermonitoring.service;


import babichev.skyscannermonitoring.entity.Subscription;
import babichev.skyscannermonitoring.to.price.FlightPriceTo;
import babichev.skyscannermonitoring.to.price.client.FlightPricesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightPriceServiceImpl implements FlightPriceService {

    private FlightPricesClient flightPricesClient;

    @Autowired
    public FlightPriceServiceImpl(FlightPricesClient flightPricesClient) {
        this.flightPricesClient = flightPricesClient;
    }

    @Override
    public Integer findMinPrice(FlightPriceTo flightPriceTo) {
        return flightPriceTo.getQuotes().get(0).getMinPrice();
    }

    @Override
    public FlightPriceTo findFlightPrice(Subscription subscription) {
       if(subscription.getInboundPartialDate() == null) {
           return flightPricesClient
                   .browseQuotes(subscription.getCountry(), subscription.getCurrency(), subscription.getLocale(),
                           subscription.getOriginPlace(), subscription.getDestinationPlace(), subscription.getOutboundPartialDate().toString());
       } else {
           return flightPricesClient
                   .browseQuotes(subscription.getCountry(), subscription.getCurrency(), subscription.getLocale(),
                           subscription.getOriginPlace(), subscription.getDestinationPlace(),
                           subscription.getOutboundPartialDate().toString(), subscription.getInboundPartialDate().toString());
       }
    }
}
