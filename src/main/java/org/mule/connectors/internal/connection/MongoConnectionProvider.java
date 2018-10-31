package org.mule.connectors.internal.connection;

import java.lang.String;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.extension.api.annotation.param.Parameter;

/**
 * This is a Connection Provider, is executed to obtain new connections when an operation or message source requires.;
 */
public class MongoConnectionProvider implements CachedConnectionProvider<MongoConnection> {
  @Parameter
  private String clientId;

  public MongoConnection connect() throws ConnectionException {
    return new MongoConnection(this.clientId);
  }

  public void disconnect(MongoConnection connection) {
    // Execute disconnection logic
  }

  public ConnectionValidationResult validate(MongoConnection connection) {
    // Execute validation logic
    return ConnectionValidationResult.success();
  }

  public String getClientId() {
    return this.clientId;
  }
}
