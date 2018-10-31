package org.mule.connectors.internal.operations;

import org.mule.connectors.internal.connection.MongoConnection;
import org.mule.metadata.api.model.MetadataType;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.metadata.MetadataContext;
import org.mule.runtime.api.metadata.MetadataKey;
import org.mule.runtime.api.metadata.MetadataKeyBuilder;
import org.mule.runtime.api.metadata.MetadataResolvingException;
import org.mule.runtime.api.metadata.resolving.InputTypeResolver;
import org.mule.runtime.api.metadata.resolving.TypeKeysResolver;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class CollectionValueProvider implements TypeKeysResolver, InputTypeResolver<String> {

//    @Connection
//    private MongoConnection mongoConnection;
//
//    public Set<Value> resolve() throws ValueResolvingException {
//        Set<Value> collections = new HashSet<>();
//
//        mongoConnection.getMongoClient().getDatabase(mongoConnection.getDatabase()).listCollectionNames().forEach((Consumer<String>) name -> collections.add(ValueBuilder.newValue(name).build()));
//
//        return collections;
//    }

    @Override
    public Set<MetadataKey> getKeys(MetadataContext metadataContext) throws MetadataResolvingException, ConnectionException {
        Set<MetadataKey> collections = new HashSet<>();
        MongoConnection mongoConnection = (MongoConnection) metadataContext.getConnection().get();

        mongoConnection.getMongoClient().getDatabase(mongoConnection.getDatabase()).listCollectionNames().forEach((Consumer<String>) name -> collections.add(MetadataKeyBuilder.newKey(name).build()));

        return collections;
    }

    @Override
    public String getCategoryName() {
        return "collections";
    }

    @Override
    public MetadataType getInputMetadata(MetadataContext metadataContext, String s) throws MetadataResolvingException, ConnectionException {
        MongoConnection mongoConnection = (MongoConnection) metadataContext.getConnection().get();
        mongoConnection.getMongoClient().getDatabase(mongoConnection.getDatabase()).getCollection(s).findOne();
        return null;
    }
}
