package babichev.skyscannermonitoring.service.email;

import babichev.skyscannermonitoring.entity.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class EmailNotifierServiceImpl implements EmailNotifierService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailNotifierServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void notifySubscriber(Subscription subscription, Integer oldMinPrice, Integer newMinPrice) {
        log.debug("method notifySubscriber STARTED");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(subscription.getEmail());
        msg.setSubject("Flight monitoring service");
        msg.setText(String.format("Hello, dear! \n" +
                "The price for your flight has decreased \n" +
                "Old min price = %s \n new min price = %s \n Subscription details = %s", oldMinPrice, newMinPrice, subscription.toString()));
        javaMailSender.send(msg);
        log.debug("method notifySubscriber FINISHED");
    }

    @Override
    public void notifyAddingSubscription(Subscription subscription) {
        log.debug("method notifyAddingSubscription STARTED");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(subscription.getEmail());
        msg.setSubject("Flight monitoring service");
        msg.setText(String.format("Hello, dear!\n" +
                "Subscription jas been successfully added. \n" +
                "Subscription details = %s", subscription.toString()));
        javaMailSender.send(msg);
        log.debug("method notifyAddingSubscription FINISHED");
    }
}
