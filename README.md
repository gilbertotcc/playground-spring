# Playground Spring

Sample service to test Spring features.

## Configuration

Environment variables that SHOULD be configured.

- `TINK_BASE_URL`. tink base URL. *(Default: <https://api.tink.com>)*
- `TINK_CLIENT_ID`. tink client id.
- `TINK_CLIENT_SECRET`. tink client secret.
- `TINK_REDIRECT_URI`.  URI to which redirect the user after account
  aggregation. 

...

## Changelog

*In the following section the top activity is the latest one.*

- Enable actuator endpoints exposed on port 8081.
  Documentation on the actuators at
- [Spring Boot Actuator Web API Documentation](https://docs.spring.io/spring-boot/docs/2.0.x/actuator-api/html/).
- Add Gradle task `buildClients` to build Python and TypeScript HTTP clients.
  Sources are generated within the `build/client` folder.
  For generator options see pages
  [Documentation for the python Generator](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/python.md)
  and
  [Documentation for the typescript-axios Generator](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/typescript-axios.md).
- Implement *API first* approach using
  [OpenAPI Generator Gradle Plugin](https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc).
  The plugin generates Java interfaces that represent the API and classes to
  represent the request/response models.
  It is configured to use the `spring` generator.
  See
  [here](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/spring.md)
  for configuration parameters.
