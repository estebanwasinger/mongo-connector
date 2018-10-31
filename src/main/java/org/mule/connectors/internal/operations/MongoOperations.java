package org.mule.connectors.internal.operations;

import java.lang.String;
import org.mule.connectors.api.MongoPublishAttributes;
import org.mule.connectors.internal.connection.MongoConnection;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.runtime.operation.Result;

public class MongoOperations {
  @MediaType("*/*")
  public Result<String, MongoPublishAttributes> postMessage(@Connection MongoConnection connection,
      String message, String destination) {
    MongoPublishAttributes attributes = new MongoPublishAttributes(connection.getClientId(), destination);
    return Result.<String,MongoPublishAttributes>builder()
        .output(message)
        .attributes(attributes)
        .build();
  }

  @MediaType("*/*")
  public String helloWorld(@Connection MongoConnection connection, String name) {
    return "Hello World!, " + name;
  }
}
