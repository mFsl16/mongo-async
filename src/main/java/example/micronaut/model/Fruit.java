package example.micronaut.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;

@Introspected
public class Fruit {


    @NotNull
    @NotBlank
    @BsonProperty("name")
    private String name;
    @Nullable
    @BsonProperty("description")
    private String description;

    public Fruit(){}

    public Fruit(@NonNull String name) {
        this(name, null);
    }

    @Creator
    @BsonCreator
    public Fruit(@NotBlank @BsonProperty("name") String name, @BsonProperty("description") String description) {
        this.name = name;
        this.description = description;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }
    
}
