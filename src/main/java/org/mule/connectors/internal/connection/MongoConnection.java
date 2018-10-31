package org.mule.connectors.internal.connection;

import java.lang.String;

public class MongoConnection {
  private String clientId;

  public MongoConnection(String clientId) {
    this.clientId = clientId;
  }

  public String getClientId() {
    return this.clientId;
  }
}
