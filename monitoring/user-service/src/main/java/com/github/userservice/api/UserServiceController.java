package com.github.userservice.api;

import com.github.userservice.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserServiceController {

    private static final Map<Integer, User> userData = new HashMap<Integer, User>() {

        private static final long serialVersionUID = -3970206781360313502L;

        {
            put(111, new User(111, "User1"));
            put(222, new User(222, "User2"));
        }
    };

    @GetMapping("users/{id}")
    public User getUser(@PathVariable("id") int userId) {

        return userData.getOrDefault(userId, new User(0, "N/A"));
    }
}
