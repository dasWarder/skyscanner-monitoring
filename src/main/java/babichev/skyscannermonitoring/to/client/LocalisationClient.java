package babichev.skyscannermonitoring.to.client;

import babichev.skyscannermonitoring.to.CountryTo;
import babichev.skyscannermonitoring.to.CurrencyTo;

import java.util.*;

public interface LocalisationClient {

    List<CountryTo> getCountries(String locale);

    List<CurrencyTo> getCurrencies();
}
