package com.example.gym.Controllers;

import com.example.gym.Entities.User;
import com.example.gym.Handlers.UserNotFoundException;
import com.example.gym.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try{
            userService.addUser(user);
            return ResponseEntity.ok().body("User added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding user");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id) {
        User user = userService.getUser(id).orElseThrow(() -> new UserNotFoundException());
        return ResponseEntity.ok().body(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        try{
            userService.deleteUSer(id);
            return ResponseEntity.ok().body("User deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error deleting user");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody User user) {
        try{
            userService.updateUser(id, user);
            return ResponseEntity.ok().body("User updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error updating user");
        }
    }
    @GetMapping("/getAll")
    @Cacheable("users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }
}
