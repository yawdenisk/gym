package com.example.gym.Services;

import com.example.gym.Entities.Training;
import com.example.gym.Repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;

    public void reserve(Training training) {
        trainingRepository.save(training);
    }

    public Optional<Training> get(UUID id) {
        return trainingRepository.findById(id);
    }

    public void delete(UUID id) {
        trainingRepository.deleteById(id);
    }
}
