# Playground Spring

Sample service to test Spring features.

## Configuration

Environment variables that SHOULD be configured.

- `SLACK_WEBHOOK_URL`, specify the URL of the Slack webhook used by Logback Slack appender.

## Changelog

*In the following section the top activity is the latest one.*

- Add Logback Slack appender [`logback-slack-appender`](https://github.com/maricn/logback-slack-appender) to append logs
  on Slack through webhooks.
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
