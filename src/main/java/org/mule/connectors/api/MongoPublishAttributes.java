package org.mule.connectors.api;

import java.lang.String;

public class MongoPublishAttributes {
  private String clientId;

  private String destination;

  public MongoPublishAttributes(String clientId, String destination) {
    this.clientId = clientId;
    this.destination = destination;
  }

  String getClientId() {
    return this.clientId;
  }

  String getDestination() {
    return this.destination;
  }
}
