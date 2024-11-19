package org.miage.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.miage.models.Product;
import org.miage.models.Store;
import org.miage.models.accounts.Admin;
import org.miage.models.accounts.Customer;
import org.miage.models.accounts.Seller;
import org.miage.models.accounts.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Database {
    public static final String dataPath = new File("").getAbsolutePath() + "\\data\\";

    public static Store load() throws IOException {
        Store store = new Store();
        ObjectMapper mapper = new ObjectMapper();

        Product[] products = mapper.readValue(new File(dataPath + "products.json"), Product[].class);
        printArray(products);
        return store;
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
