package com.example.springbootsecuritydbdemo;

import org.apache.catalina.Context;
import org.apache.catalina.session.StandardManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSecurityDbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDbDemoApplication.class, args);
    }


}
