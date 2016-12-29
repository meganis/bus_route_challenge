package com.goeuro.direct;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.goeuro.direct.api.DirectService;
import com.goeuro.direct.impl.DirectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.IOException;

/**
 * Created by segr on 21.12.16.
 */
@SpringBootApplication(scanBasePackages = "com.goeuro")
public class DirectApp {
    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(DirectApp.class, args);
    }

    @Bean
    public JacksonJsonProvider jacksonJsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public DirectService directService() throws IOException {
        String[] nonOptionArgs = env.getProperty("nonOptionArgs", String[].class);
        if (nonOptionArgs == null || nonOptionArgs.length != 1) {
            throw new IllegalArgumentException("missing path");
        }

        DirectServiceImpl directService = new DirectServiceImpl();
        directService.readData(nonOptionArgs[0]);
        return directService;
    }
}
