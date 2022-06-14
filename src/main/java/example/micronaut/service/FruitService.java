package example.micronaut.service;

import java.util.List;

import javax.validation.Valid;

import example.micronaut.model.Fruit;
import example.micronaut.repository.FruitRepository;
import jakarta.inject.Singleton;

@Singleton
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> getFruitList() {
        return fruitRepository.listFruit();
    }

    public Fruit save(@Valid Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public List<Fruit> getFruitByName(String name) {
        return fruitRepository.findByName(name);
    }

}
