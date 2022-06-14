package example.micronaut.config.properties;

import javax.validation.constraints.NotBlank;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.naming.Named;


@ConfigurationProperties("app.mongo")
public interface MongoProperties extends Named {
    
    @NonNull
    @NotBlank
    public String getUri();

    @NonNull
    @NotBlank
    public String getCollection();
   
}