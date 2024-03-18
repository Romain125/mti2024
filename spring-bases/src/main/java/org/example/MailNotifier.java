package org.example;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("MAIL")
@Component
public class MailNotifier implements Notifier{

    @Override
    public void notifyUser(User user) {
        System.out.println("Mail sent to "+user.getName()+":"+user.getMail());
    }
}
