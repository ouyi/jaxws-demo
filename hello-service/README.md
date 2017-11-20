
# Simple example JAX-WS web service

## Build

```
mvn package
```

## Deploy

```
asadmin -u admin -W /tmp/glassfishpwd deploy /tmp/hello-service-0.0.1.war
```

## Test

```
curl -SL http://localhost:8080/hello-service-0.0.1/HelloService?wsdl
```
