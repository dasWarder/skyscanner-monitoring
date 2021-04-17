package babichev.skyscannermonitoring.service.email;

import babichev.skyscannermonitoring.entity.Subscription;

public interface EmailNotifierService {

    void notifySubscriber(Subscription subscription, Integer oldMinPrice, Integer newMinPrice);

    void notifyAddingSubscription(Subscription subscription);
}
