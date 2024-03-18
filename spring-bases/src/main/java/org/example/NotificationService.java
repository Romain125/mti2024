package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private Notifier notifier;
    private NotificationTracer tracer;

    @Autowired
    public NotificationService(Notifier notifier, NotificationTracer tracer) {
        this.notifier = notifier;
        this.tracer = tracer;
    }

    public void notify(User user) {
        notifier.notifyUser(user);
        tracer.traceNotification();
    }
}
