# Simple example JAX-WS web service client

## Development steps

- Generate endpoint source code (proxies)
- Code the client

## Run the application

```
java -jar /tmp/hello-client-1.0-SNAPSHOT.jar
```

## NPE

```
java -jar /tmp/hello-client-1.0-SNAPSHOT.jar
Exception in thread "main" java.lang.NullPointerException
    at io.github.ouyi.jaxws.HelloClient.sayHello(HelloClient.java:21)
    at io.github.ouyi.jaxws.HelloClient.main(HelloClient.java:17)
```

Remove
```
    @WebServiceRef(wsdlLocation = 
      "http://localhost:8080/hello-service-0.0.1/HelloService?wsdl")
    private static HelloService service;

```

Add
```
    URL wsdlLocation = new URL("http://localhost:8080/hello-service-0.0.1/HelloService?wsdl");
    HelloService service = new HelloService(wsdlLocation);
```
