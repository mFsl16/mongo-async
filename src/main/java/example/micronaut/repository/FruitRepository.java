package example.micronaut.repository;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import example.micronaut.model.Fruit;
import io.micronaut.core.annotation.NonNull;

public interface FruitRepository {

    @NonNull
    List<Fruit> listFruit();

    Fruit save(@NonNull @NotNull @Valid Fruit fruit);
    
}
