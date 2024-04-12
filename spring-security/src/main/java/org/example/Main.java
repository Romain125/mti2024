package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}

@RestController
class MyController{

    private MyService service;
    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Bonjour!";
    }

    @GetMapping("/user/hello")
    public String userHello(@AuthenticationPrincipal UserDetails user){
        return service.helloUser(user.getUsername(), user.getAuthorities());
    }

    @GetMapping("/admin/hello")
    public String adminHello(@AuthenticationPrincipal UserDetails user){
        return service.helloAdmin(user.getUsername(), user.getAuthorities());
    }

}

@Service
class MyService{

    public String helloPublic(){
        return "Hello dear unknown person !";
    }

    @PreAuthorize("hasRole('USER')")
    public String helloUser(String user, Collection<? extends GrantedAuthority> authorities){
        return "Hello dear user "+user+" with roles "+authorities;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String helloAdmin(String user, Collection<? extends GrantedAuthority> authorities){
        return "Hello dear admin "+user+" with roles "+authorities;
    }

}