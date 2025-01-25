package com.example.gym.Services;

import com.example.gym.Entities.User;
import com.example.gym.Handlers.UserNotFoundException;
import com.example.gym.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void addUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUser(UUID id) {
        return userRepository.findById(id);
    }

    public void deleteUSer(UUID id) {
        userRepository.deleteById(id);
    }

    public void updateUser(UUID id, User user) {
        User oldUSer = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException());
        oldUSer.setName(user.getName());
        oldUSer.setEmail(user.getEmail());
        oldUSer.setPhone(user.getPhone());
        userRepository.save(oldUSer);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
