package example.micronaut.client;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import example.micronaut.model.Fruit;

public class FruitCodec implements Codec<Fruit> {

    @Override
    public void encode(BsonWriter arg0, Fruit arg1, EncoderContext arg2) {
        
        arg0.writeString(arg1.getName());
        arg0.writeString(arg1.getDescription());
        
    }

    @Override
    public Class<Fruit> getEncoderClass() {
        return Fruit.class;
    }

    @Override
    public Fruit decode(BsonReader reader, DecoderContext decoderContext) {
        String name = reader.readString("name");
        String desc = reader.readString("description");

        return new Fruit(name, desc);
    }
    
}
