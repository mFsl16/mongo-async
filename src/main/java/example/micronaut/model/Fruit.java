package example.micronaut.model;

import javax.validation.constraints.NotBlank;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;

@Introspected
public class Fruit {
    
    @NonNull
    @NotBlank
    @BsonProperty("name")
    private final String name;

    @Nullable
    @BsonProperty("description")
    private final String description;

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
