package org.miage.database;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.miage.models.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class HashMapProductIntegerDeserializer extends JsonDeserializer<HashMap<Product, Integer>> {
    List<Product> products;

    HashMapProductIntegerDeserializer(List<Product> products) {
        this.products = products;
    }

    @Override
    public HashMap<Product, Integer> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        HashMap<Product, Integer> productIntegerHashMap = new HashMap<>();

        if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
            jsonParser.nextToken();
        }

        while (jsonParser.currentToken() == JsonToken.FIELD_NAME) {
            String productName = jsonParser.getCurrentName();
            Integer value = jsonParser.getIntValue();

            Product product = null;

            for (Product p : products) {
                if (p.getName().equals(productName)) {
                    product = p;
                }
            }

            productIntegerHashMap.put(product, value);

            jsonParser.nextToken();
        }

        return productIntegerHashMap;
    }
}
