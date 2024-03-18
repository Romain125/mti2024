package org.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("SMS")
@Component
public class SmsNotifier implements Notifier{
    @Override
    public void notifyUser(User user) {
        System.out.println("SMS sent to "+user.getName()+":"+user.getPhone());
    }
}
