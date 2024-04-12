package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

@Configuration
@EnableMethodSecurity(
        prePostEnabled = true
)
public class MySecurityConfiguration {

    @Bean
    public SecurityFilterChain sfc(HttpSecurity http) throws Exception {
        return http
                .formLogin(login -> login.defaultSuccessUrl("/hello")
                        .usernameParameter("usr")
                        .passwordParameter("pwd")
//                        .loginProcessingUrl("/myLoginUrl")
//                                .loginPage("/myPage")
                        )
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
//                .exceptionHandling(
//                        handler ->
//                                handler.authenticationEntryPoint(new Http403ForbiddenEntryPoint())
//                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/hello").permitAll()
                        .requestMatchers("/user/**").hasRole("USER")
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(session -> session
                        .maximumSessions(1)
//                        .expiredSessionStrategy()
                )
                .build();

//        return http
//            .formLogin(formLogin -> formLogin.disable())
//                .httpBasic(basic -> basic.realmName("Toto"))
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                .build();

    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails u = User.builder()
                .username("user")
                .password(encoder().encode("u"))
                .roles("USER")
                .build();
        UserDetails a = User.builder()
                .username("admin")
                .password(encoder().encode("a"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(u, a);
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
