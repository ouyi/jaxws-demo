package io.github.ouyi;

import io.github.ouyi.jaxws.HelloClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class Application {

    @Value("${wsdl.location}")
    private String wsdlLocation;

    @Bean
    HelloClient helloClient() throws MalformedURLException {
         return new HelloClient(new URL(wsdlLocation));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
