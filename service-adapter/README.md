## Build

```
./gradlew build
```

## Run

```
java -jar ./build/libs/service-adapter-1.0-SNAPSHOT.jar --server.port=8090 --wsdl.location="http://localhost:18080/hello-service-0.0.1/HelloService?wsdl"
```

## 

Swagger api docs accessible under `http://localhost:8090/v2/api-docs` and `http://localhost:8090/swagger-ui.html`
