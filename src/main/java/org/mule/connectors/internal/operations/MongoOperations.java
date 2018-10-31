package org.mule.connectors.internal.operations;

import java.io.InputStream;
import java.lang.String;
import org.mule.connectors.api.MongoPublishAttributes;
import org.mule.connectors.internal.connection.MongoConnection;
import org.mule.runtime.core.api.util.IOUtils;
import org.mule.runtime.extension.api.annotation.metadata.MetadataKeyId;
import org.mule.runtime.extension.api.annotation.metadata.TypeResolver;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.values.OfValues;
import org.mule.runtime.extension.api.runtime.operation.Result;

import org.bson.Document;

public class MongoOperations {


  public void insertDocument(@Connection MongoConnection connection,
                             @MetadataKeyId(CollectionValueProvider.class) String collection,
                             @TypeResolver (CollectionValueProvider.class)@Content InputStream document) {
    connection.getMongoClient()
            .getDatabase(connection.getDatabase())
            .getCollection(collection)
            .insertOne(Document.parse(IOUtils.toString(document)));
  }
}
