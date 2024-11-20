package org.miage.database;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import org.miage.models.Product;
import org.miage.models.accounts.Seller;

import java.io.IOException;
import java.util.*;

public class HashMapSellerProductDeserializer extends JsonDeserializer<HashMap<Seller, ArrayList<Product>>> {

    HashMapSellerProductDeserializer(){
    }

    @Override
    public HashMap<Seller, ArrayList<Product>> deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {
        HashMap<Seller, ArrayList<Product>> result = new HashMap<>();
        ObjectMapper mapper = (ObjectMapper) parser.getCodec();
        JsonNode rootNode = mapper.readTree(parser);

        Iterator<HashMap.Entry<String, JsonNode>> fields = rootNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String idUser = field.getKey();
            JsonNode productsNode = field.getValue();

            List<Product> products = (List<Product>) deserializationContext.findInjectableValue("products", null, null);
            List<Seller> sellers = (List<Seller>) deserializationContext.findInjectableValue("sellers", null, null);

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