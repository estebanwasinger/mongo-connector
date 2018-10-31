package org.mule.connectors.internal.connection;

import com.mongodb.client.MongoClient;

public class MongoConnection {
  private MongoClient mongoClient;
  private String database;

  public MongoConnection(MongoClient mongoClient, String database) {
    this.mongoClient = mongoClient;
    this.database = database;
  }

  public MongoClient getMongoClient() {
    return mongoClient;
  }

  public String getDatabase() {
    return database;
  }
}
