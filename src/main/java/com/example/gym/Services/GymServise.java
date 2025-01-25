package com.example.gym.Services;

import com.example.gym.Entities.Gym;
import com.example.gym.Handlers.GymNotFoundException;
import com.example.gym.Repositories.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GymServise {
    @Autowired
    private GymRepository gymRepository;
    public void addGym(Gym gym) {
        gymRepository.save(gym);
    }

    public Optional<Gym> getGym(UUID id) {
        return gymRepository.findById(id);
    }

    public void updateGym(UUID id, Gym gym) {
        Gym oldGym = gymRepository.findById(id).orElseThrow(() -> new GymNotFoundException());
        oldGym.setName(gym.getName());
        gymRepository.save(gym);
    }

    public void deleteGym(UUID id) {
        gymRepository.deleteById(id);
    }
}
