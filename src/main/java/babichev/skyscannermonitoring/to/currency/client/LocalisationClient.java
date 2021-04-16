package babichev.skyscannermonitoring.to.currency.client;

import babichev.skyscannermonitoring.to.currency.CountryTo;
import babichev.skyscannermonitoring.to.currency.CurrencyTo;

import java.util.*;

public interface LocalisationClient {

    List<CountryTo> getCountries(String locale);

    List<CurrencyTo> getCurrencies();
}
