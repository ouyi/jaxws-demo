package io.github.ouyi;

import io.github.ouyi.jaxrs.GreetingController;
import io.github.ouyi.jaxws.HelloClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
@EnableSwagger2
public class Application {

    @Value("${wsdl.location}")
    private String wsdlLocation;

    @Bean
    HelloClient helloClient() throws MalformedURLException {
        return new HelloClient(new URL(wsdlLocation));
    }

    @Bean
    public Docket greetingApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(GreetingController.class.getPackage().getName()))
                .paths(PathSelectors.regex(".*"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
