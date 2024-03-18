package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class NotificationTracer {

    private String fileName;

    @Autowired
    public NotificationTracer(@Value("${filename:toto.txt}") String fileName) {
        this.fileName = fileName;
    }

    void traceNotification(){
        try {
            Files.writeString(Path.of(fileName),  "Notification sent");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
