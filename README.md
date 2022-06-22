# Playground Spring

Sample service to test Spring features.

## Changelog

- Implement *API first* approach using
  [OpenAPI Generator Gradle Plugin](https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc).
  The plugin generates Java interfaces that represent the API and classes to
  represent the request/response models.
  It is configured to use the `spring` generator.
  See
  [here](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/spring.md)
  for configuration parameters.
