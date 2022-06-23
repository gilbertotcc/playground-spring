package it.tccr.puppet.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;


import java.util.*;
import javax.annotation.Generated;

/**
 * HealthCheckResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-23T02:12:03.364341+02:00[Europe/Rome]")
public class HealthCheckResponse {

  /**
   * Code describing the healthiness of the service
   */
  public enum CodeEnum {
    HEALTHY("HEALTHY"),
    
    UNHEALTHY("UNHEALTHY");

    private String value;

    CodeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CodeEnum fromValue(String value) {
      for (CodeEnum b : CodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("code")
  private CodeEnum code;

  @JsonProperty("message")
  private String message;

  public HealthCheckResponse code(CodeEnum code) {
    this.code = code;
    return this;
  }

  /**
   * Code describing the healthiness of the service
   * @return code
  */
  public CodeEnum getCode() {
    return code;
  }

  public void setCode(CodeEnum code) {
    this.code = code;
  }

  public HealthCheckResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Human-readable description of the health status
   * @return message
  */
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthCheckResponse healthCheckResponse = (HealthCheckResponse) o;
    return Objects.equals(this.code, healthCheckResponse.code) &&
        Objects.equals(this.message, healthCheckResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckResponse {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

