package org.mule.connectors.internal.connection;

import java.lang.String;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.param.Parameter;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * This is a Connection Provider, is executed to obtain new connections when an operation or message source requires.;
 */
public class MongoConnectionProvider implements CachedConnectionProvider<MongoConnection> {

  @Parameter
  private String connectionString;

  public MongoConnection connect() throws ConnectionException {
    MongoClient mongoClient = MongoClients.create(connectionString);
    return new MongoConnection(mongoClient);
  }

  public void disconnect(MongoConnection connection) {
    connection.getMongoClient().close();
  }

  public ConnectionValidationResult validate(MongoConnection connection) {
    // Execute validation logic
    return ConnectionValidationResult.success();
  }

}
