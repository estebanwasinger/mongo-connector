package org.mule.connectors.internal;

import org.mule.connectors.internal.connection.MongoConnectionProvider;
import org.mule.connectors.internal.operations.MongoOperations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;

@Extension(
    name = "Mongo"
)
@Operations(MongoOperations.class)
@ConnectionProviders(MongoConnectionProvider.class)
public class MongoConnector {
}
