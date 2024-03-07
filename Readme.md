
# MyFactory

This is an API for a hyptetical unsecured factory.
This API implements a lot of endpoints that can be found in the [API documentation](./documentation.md).
The documentation is generated dynamically at runtime by the DocumentationGenerator,
This is a tool we developed to keep track of all our endpoints.

## Testing 
```
./mvnw test
```

## Generating Documentation
```
./mvnw spring-boot:run -Dspring-boot.run.arguments=--documentation 
```

## Running
```
./mvnw spring-boot:run
```


