package org.miage.database;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.miage.models.Product;
import org.miage.models.accounts.Seller;

import java.io.IOException;
import java.util.*;

public class HashMapSellerProductDeserializer extends JsonDeserializer<HashMap<Seller, ArrayList<Product>>> {
    List<Product> products;
    List<Seller> sellers;

    HashMapSellerProductDeserializer(List<Seller> sellers, List<Product> products) {
        this.products = products;
        this.sellers = sellers;
    }

    @Override
    public HashMap<Seller, ArrayList<Product>> deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        HashMap<Seller, ArrayList<Product>> result = new HashMap<>();
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        JsonNode rootNode = mapper.readTree(parser);

        Iterator<HashMap.Entry<String, JsonNode>> fields = rootNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String idUser = field.getKey();
            JsonNode productsNode = field.getValue();

            Seller seller = null;
            for (Seller s : sellers) {
                if (s.getIdUser().equals(idUser)) {
                    seller = s;
                }
            }

            // Construct the list of Product objects
            ArrayList<Product> sellersProducts = new ArrayList<>();
            for (JsonNode productNameNode : productsNode) {
                String productName = productNameNode.asText();

                Product product = null;
                for (Product p : products) {
                    if (p.getName().equals(productName)) {
                        product = p;
                    }
                }

                sellersProducts.add(product);
            }

            result.put(seller, sellersProducts);
        }
        return result;
    }
}