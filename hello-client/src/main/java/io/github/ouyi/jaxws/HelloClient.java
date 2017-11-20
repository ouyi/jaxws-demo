package io.github.ouyi.jaxws;

import io.github.ouyi.jaxws.helloservice.endpoint.Hello;
import io.github.ouyi.jaxws.helloservice.endpoint.HelloService;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 */
public class HelloClient {

    public static void main(String[] args) throws MalformedURLException {
        System.out.println(sayHello("world"));
    }

    private static String sayHello(String name) throws MalformedURLException {
        URL wsdlLocation = new URL("http://localhost:8080/hello-service-0.0.1/HelloService?wsdl");
        HelloService service = new HelloService(wsdlLocation);
        Hello port = service.getHelloPort();
        return port.sayHello(name);
    }
}
