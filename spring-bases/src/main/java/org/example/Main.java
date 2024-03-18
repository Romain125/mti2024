package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanner.class);

        NotificationService notificationService = context.getBean("notificationService", NotificationService.class);
        notificationService.notify(new User("romain.noel@mail.com", "Romain", "012345678"));
        notificationService.notify(new User("donald.duck@mail.com", "Donald", "0187654321"));

    }
}