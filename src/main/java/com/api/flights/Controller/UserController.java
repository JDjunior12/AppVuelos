package com.api.flights.Controller;

import com.api.flights.Models.User;
import com.api.flights.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @PostMapping
    public ResponseEntity<User> newUser(@RequestBody User user){
        return this.userService.newUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return this.userService.updateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
    }


}
