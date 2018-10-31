package org.mule.connectors.internal.operations;

import org.mule.connectors.internal.connection.MongoConnection;
import org.mule.runtime.api.value.Value;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.values.ValueBuilder;
import org.mule.runtime.extension.api.values.ValueProvider;
import org.mule.runtime.extension.api.values.ValueResolvingException;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class DatabaseValueProvider implements ValueProvider {

    @Connection
    private MongoConnection mongoConnection;

    @Override
    public Set<Value> resolve() throws ValueResolvingException {
        Set<Value> databases = new HashSet<>();

        mongoConnection.getMongoClient().listDatabaseNames().forEach((Consumer<String>) name -> databases.add(ValueBuilder.newValue(name).build()));

        return databases;
    }
}
