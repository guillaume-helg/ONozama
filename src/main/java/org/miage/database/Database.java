package org.miage.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.miage.models.*;
import org.miage.models.accounts.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Database {
    public static final String dataPath = new File("").getAbsolutePath() + "\\data\\";

    public static Store store;

    public static void load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Product[] products = mapper.readValue(new File(dataPath + "products.json"), Product[].class);
        Seller[] sellers = mapper.readValue(new File(dataPath + "sellers.json"), Seller[].class);
        Admin[] admins = mapper.readValue(new File(dataPath + "admins.json"), Admin[].class);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(HashMap.class, new HashMapProductIntegerDeserializer(Arrays.asList(products)));
        module.addDeserializer(HashMap.class, new HashMapSellerProductDeserializer(Arrays.asList(sellers), Arrays.asList(products)));
        mapper.registerModule(module);

        Database.store = mapper.readValue(new File(dataPath + "store.json"), Store.class);

        for(Admin admin : admins) {
            admin.setStore(Database.store);
        }

        Customer[] customers = mapper.readValue(new File(dataPath + "customers.json"), Customer[].class);

        List<User> users = Database.store.getUserList();
        users.addAll(List.of(customers));
        users.addAll(List.of(admins));
        users.addAll(List.of(sellers));

    }

    private static <T> List<T> flatten(Collection<ArrayList<T>> nestedList) {
        List<T> ls = new ArrayList<>();
        nestedList.forEach(ls::addAll);
        return ls;
    }

    private static void printArray(Object[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void save(Store store) throws IOException {
        List<Product> products = flatten(store.getProductHashMap().values());

        ObjectMapper mapper = new ObjectMapper();

        List<Admin> admins = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Seller> sellers = new ArrayList<>();

        for (User user : store.getUserList()){
            if (user instanceof Admin){
                admins.add((Admin) user);
            } else if (user instanceof Seller){
                sellers.add((Seller) user);
            } else{
                customers.add((Customer) user);
            }
        }

        mapper.writeValue(new File(dataPath + "products.json"), products);
        mapper.writeValue(new File(dataPath + "admins.json"), admins);
        mapper.writeValue(new File(dataPath + "sellers.json"), sellers);
        mapper.writeValue(new File(dataPath + "customers.json"), customers);
        mapper.writeValue(new File(dataPath + "store.json"), store);
    }
}
