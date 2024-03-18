package org.example;

import org.example.exceptions.PlayerNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(PlayerNotFound.class)
    public ResponseEntity<String> handleException(){
        return ResponseEntity
                //.of(Optional.of("No player found"))
                .status(404)
                .build();
    }

}
