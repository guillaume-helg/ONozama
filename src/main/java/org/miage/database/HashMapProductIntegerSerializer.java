package org.miage.database;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.miage.models.Product;

import java.io.IOException;
import java.util.HashMap;

public class HashMapProductIntegerSerializer extends JsonSerializer<HashMap<Product, Integer>> {

    @Override
    public void serialize(HashMap<Product, Integer> productIntegerHashMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for (HashMap.Entry<Product, Integer> entry : productIntegerHashMap.entrySet()) {
            String key = entry.getKey().getName();
            jsonGenerator.writeObjectField(key, entry.getValue());
        }
        jsonGenerator.writeEndObject();
    }
}
