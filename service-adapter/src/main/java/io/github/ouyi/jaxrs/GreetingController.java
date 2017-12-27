package io.github.ouyi.jaxrs;

import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicLong;

import io.github.ouyi.jaxws.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    public static final String GREET_PATH = "/greeting";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private HelloClient helloClient;

    @RequestMapping(value = GREET_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws MalformedURLException {
        return new Greeting(counter.incrementAndGet(), helloClient.sayHello(name));
    }
}
