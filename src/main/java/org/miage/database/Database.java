package org.miage.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.miage.models.Store;

import java.io.File;
import java.io.IOException;

public class Database {
    public static final String dataPath = new File("").getAbsolutePath() + "\\data\\";

    public static Store load(String filename) throws IOException {
        Store store;
        ObjectMapper mapper = new ObjectMapper();

        store = mapper.readValue(new File(dataPath + filename), Store.class);

        return store;
    }

    public static void save(Store store, String filename) throws IOException {


        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(dataPath), store);
    }
}
