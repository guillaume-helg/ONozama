package org.miage.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import org.miage.models.accounts.User;

import java.io.IOException;

public class UserDeserializer extends KeyDeserializer {
    @Override
    public User deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        //Use the string key here to return a real map key object
        return mapKey;
    }
}
