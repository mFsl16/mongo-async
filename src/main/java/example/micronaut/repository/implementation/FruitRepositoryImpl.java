package example.micronaut.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import example.micronaut.config.properties.MongoProperties;
import example.micronaut.model.Fruit;
import example.micronaut.repository.FruitRepository;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
public class FruitRepositoryImpl implements FruitRepository {

    private final MongoProperties mongoProperties;
    private final MongoClient mongoClient;

    

    public FruitRepositoryImpl(MongoProperties mongoProperties, MongoClient mongoClient) {
        this.mongoProperties = mongoProperties;
        this.mongoClient = mongoClient;
    }

    @Override
    public List<Fruit> listFruit() {
        List<Fruit> listFruit = getCollection().find().into(new ArrayList<>());
        return listFruit;
    }

    @Override
    public Fruit save(@NotNull @Valid Fruit fruit) {
        getCollection().insertOne(fruit);
        return fruit;
    }

    @NonNull
    private MongoCollection<Fruit> getCollection() {
        return mongoClient.getDatabase(mongoProperties.getName()).getCollection(mongoProperties.getCollection(), Fruit.class);
    }
    
}
