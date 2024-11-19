package org.miage.database;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.miage.models.Product;
import org.miage.models.accounts.Seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapSellerProductSerializer extends JsonSerializer<HashMap<Seller, ArrayList<Product>>> {

    @Override
    public void serialize(HashMap<Seller, ArrayList<Product>> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        for (HashMap.Entry<Seller, ArrayList<Product>> entry : value.entrySet()) {
            Seller seller = entry.getKey();
            ArrayList<Product> products = entry.getValue();

            gen.writeFieldName(seller.getIdUser());

            gen.writeStartArray();
            for (Product product : products) {
                gen.writeObject(product.getName());
            }
            gen.writeEndArray();
        }

        gen.writeEndObject();
    }
}
