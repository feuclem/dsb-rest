package com.dsb.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication 
public class DsbApplication {
    public static void main(String[] args) {
        SpringApplication.run(DsbApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/amulettes/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/anneaux/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/armes/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/bottes/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/boucliers/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/capes/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/ceintures/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/coiffes/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/dofus/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/familiers/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/montures/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/panoplies/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
                registry.addMapping("/trophees/*").allowedOrigins("http://localhost:4200", "https://testdsb.herokuapp.com");
            }
        };
    }
}
