This is a small sample app to demonstrate the issues described in [InstanceAlreadyExistsException during continuous build #5286](https://github.com/spring-projects/spring-boot/issues/5286).

### Steps to reproduce

- Execute `./gradlew -t run`. This starts the application and will continuously build and restart it if something in `src` changes.
  - The application will start without problems, listening on localhost:5050.
  - It will also print log messages indicating that the endpoints have been registered as expected.
- Change something in `src`. A good condidate would be `src/main/resources/logback.xml`. A newline is sufficient.
- Lots of exceptions are printed on the console.

`210844 [main] ERROR o.s.b.a.e.jmx.EndpointMBeanExporter - Could not register MBean for endpoint [environmentEndpoint]
org.springframework.jmx.export.UnableToRegisterMBeanException: Unable to register MBean [org.springframework.boot.actuate.endpoint.jmx.DataEndpointMBean@19f1fb43] with key 'environmentEndpoint'; nested exception is javax.management.InstanceAlreadyExistsException: org.springframework.boot:type=Endpoint,name=environmentEndpoint`