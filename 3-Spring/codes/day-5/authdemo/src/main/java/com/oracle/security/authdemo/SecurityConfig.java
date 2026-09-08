package com.oracle.security.authdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
            throws Exception {
        return httpSecurity
                .csrf(config -> config.disable())
                .authorizeHttpRequests(request ->
                        request.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        User.UserBuilder builder = User.builder();

        builder.username("Joydip");
        //builder.password("{noop}Joydip@123");
        builder.password(passwordEncoder.encode("Joydip@123"));
        builder.roles("USER");
        UserDetails user1 = builder.build();

        builder.username("naveen");
        builder.password(passwordEncoder.encode("Naveen@123"));
        builder.roles("Admin");
        UserDetails user2 = builder.build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
