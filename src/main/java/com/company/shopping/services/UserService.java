package com.company.shopping.services;

import com.company.shopping.entity.User;
import com.company.shopping.repository.UserRepository;
import com.company.shopping.util.ConvertToJsonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final ConvertToJsonUtil convertor = new ConvertToJsonUtil();

    public String login(String input) throws Exception {
        JsonObject jsonObject = new Gson().fromJson(input, JsonObject.class);
        String userId = jsonObject.get("userId").getAsString();
        String password = jsonObject.get("password").getAsString();

        Optional<User> userPresent = userRepository.getUserByEmail(userId);

        if (userPresent.isPresent()) {
            User user = userPresent.get();
            if (password.equals(user.getPassword())) {
                JsonObject userData = new Gson().fromJson(convertor.convertToJson(user), JsonObject.class);
                userData.remove("password");
                return userData.toString();
            } else {
                throw new Exception("Incorrect Password Entered.");
            }
        } else {
            throw new Exception(String.format("User with ID: %s does not exist", userId));
        }
    }
}
