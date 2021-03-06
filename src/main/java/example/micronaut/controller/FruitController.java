package example.micronaut.controller;

import java.util.List;

import javax.validation.Valid;

import example.micronaut.model.Fruit;
import example.micronaut.service.FruitService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

@Controller("/fruit")
public class FruitController {
    
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Get()
    public HttpResponse<?> getFruitList() {

        List<Fruit> listFruits = fruitService.getFruitList();

        return HttpResponse.ok(listFruits);
    }

    @Post()
    public HttpResponse<?> saveFruit(@Valid @Body Fruit fruit) {

        return HttpResponse.ok(fruitService.save(fruit));
    }

    @Get("/{name}")
    public HttpResponse<?> getFruitByName(@PathVariable String name) {
        return HttpResponse.ok(fruitService.getFruitByName(name));
    }

    
}
