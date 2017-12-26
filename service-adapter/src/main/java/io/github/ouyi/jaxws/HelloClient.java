package io.github.ouyi.jaxws;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 */
public class HelloClient {

    private final URL wsdlLocation;

    public HelloClient(URL wsdlLocation) {
        this.wsdlLocation = wsdlLocation;
    }

    public String sayHello(String name) throws MalformedURLException {
        HelloService service = new HelloService(wsdlLocation);
        Hello port = service.getHelloPort();
        return port.sayHello(name);
    }
}
