package org.mule.connectors.internal.connection;

import com.mongodb.client.MongoClient;

public class MongoConnection {
  private MongoClient mongoClient;

  public MongoConnection(MongoClient mongoClient) {
    this.mongoClient = mongoClient;
  }

  public MongoClient getMongoClient() {
    return mongoClient;
  }
}
