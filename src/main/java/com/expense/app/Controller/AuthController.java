package com.expense.app.Controller;

import com.expense.app.Model.User;
import com.expense.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {

        Map<String, Object> userPresentObj = userService.isUserPresent(user);
        if ((Boolean) userPresentObj.get("isexists")) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        userService.createUser(user);

        return ResponseEntity.ok(user);
    }
}
