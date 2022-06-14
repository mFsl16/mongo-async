package example.micronaut.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import example.micronaut.config.properties.MongoProperties;
import example.micronaut.model.Fruit;
import example.micronaut.repository.FruitRepository;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

@Singleton
public class FruitRepdositoryImpl implements FruitRepository {

    private final MongoProperties mongoProperties;
    private final MongoClient mongoClient;

    public FruitRepdositoryImpl(MongoProperties mongoProperties, MongoClient mongoClient) {
        this.mongoProperties = mongoProperties;
        this.mongoClient = mongoClient;
    }

    @Override
    public List<Fruit> listFruit() {
        return getCollection().find().into(new ArrayList<>());
    }

    @Override
    public Fruit save(@NotNull @Valid Fruit fruit) {
        getCollection().insertOne(fruit);
        return fruit;
    }

    @Override
    public ArrayList<Fruit> findByName(@NotNull String name) {
        BasicDBObject searchFilter = new BasicDBObject("name", name);
        ArrayList<Fruit> fruits = getCollection().find(searchFilter).into(new ArrayList<>());
        return fruits;
    }

    @NonNull
    private MongoCollection<Fruit> getCollection() {
        return mongoClient.getDatabase(mongoProperties.getName()).getCollection(mongoProperties.getCollection(), Fruit.class);
    }
    
}
