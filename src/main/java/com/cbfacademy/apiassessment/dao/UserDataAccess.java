package com.cbfacademy.apiassessment.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

/**
 * users data access.
 */
@Repository("userDAO") // need to be instantiated as a beans
public class UserDataAccess implements PersonDAO {

    File file = new File("src/main/resources/dbUsersFile.json");


    @Override
    public List<User> readFile() {
    List<User> dbUser = new ArrayList<>();
    
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        
        try (JsonReader reader = new JsonReader(new FileReader(file.getAbsolutePath()));) {
            System.out.println(reader.toString());
            dbUser = gson.fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dbUser);
        return dbUser;
    }


    @Override
    public void save(User user) {
        List<User> updateListOfUsers = new ArrayList<>();
        List<User> readUserFromFile = readFile();

        try (
            FileWriter writer = new FileWriter(file.getAbsolutePath());
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            ) {
            if (readUserFromFile != null) {
                updateListOfUsers = readUserFromFile;
            }


            updateListOfUsers.add(user);
    

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(updateListOfUsers, bufferedWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
