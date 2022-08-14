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
 * Connection
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Connection {

  @JsonProperty("accountConnectionId")
  private String accountConnectionId;

  @JsonProperty("connectionLink")
  private String connectionLink;

  public Connection accountConnectionId(String accountConnectionId) {
    this.accountConnectionId = accountConnectionId;
    return this;
  }

  /**
   * Unique identifier of the connection
   * @return accountConnectionId
  */
  public String getAccountConnectionId() {
    return accountConnectionId;
  }

  public void setAccountConnectionId(String accountConnectionId) {
    this.accountConnectionId = accountConnectionId;
  }

  public Connection connectionLink(String connectionLink) {
    this.connectionLink = connectionLink;
    return this;
  }

  /**
   * Link to connect the account
   * @return connectionLink
  */
  public String getConnectionLink() {
    return connectionLink;
  }

  public void setConnectionLink(String connectionLink) {
    this.connectionLink = connectionLink;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Connection connection = (Connection) o;
    return Objects.equals(this.accountConnectionId, connection.accountConnectionId) &&
        Objects.equals(this.connectionLink, connection.connectionLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountConnectionId, connectionLink);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Connection {\n");
    sb.append("    accountConnectionId: ").append(toIndentedString(accountConnectionId)).append("\n");
    sb.append("    connectionLink: ").append(toIndentedString(connectionLink)).append("\n");
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

