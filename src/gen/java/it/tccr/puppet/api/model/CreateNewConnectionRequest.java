package it.tccr.puppet.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreateNewConnectionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CreateNewConnectionRequest {

  @JsonProperty("code")
  private String code;

  public CreateNewConnectionRequest code(String code) {
    this.code = code;
    return this;
  }

  /**
   * tink code returned by the access flow
   * @return code
  */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateNewConnectionRequest createNewConnectionRequest = (CreateNewConnectionRequest) o;
    return Objects.equals(this.code, createNewConnectionRequest.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateNewConnectionRequest {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

