package example.micronaut.config.properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest()
public class MongoPropertiesTest {

    @Inject 
    MongoProperties mongoProperties;

    @Test
    void testGetCollection() {
        assertTrue(mongoProperties.getCollection() != null && mongoProperties.getCollection().length() > 0);

    }

    @Test
    void testGetUri() {
        assertTrue(mongoProperties.getUri() != null && mongoProperties.getUri().length() > 0);
    }
}
