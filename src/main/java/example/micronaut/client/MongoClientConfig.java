package example.micronaut.client;

import org.bson.codecs.configuration.CodecRegistries;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import example.micronaut.config.properties.MongoProperties;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Factory
public class MongoClientConfig {
    
    private final MongoProperties mongoProperties;

    public MongoClientConfig(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    public MongoClient mongoClient() {

        MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(mongoProperties.getUri()))
            // .codecRegistry(CodecRegistries.fromCodecs(new FruitCodec()))
            .build();
        MongoClient mongoClient = MongoClients.create(settings);

        return mongoClient;
    }
}
