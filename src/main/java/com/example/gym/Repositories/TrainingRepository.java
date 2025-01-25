package com.example.gym.Repositories;

import com.example.gym.Entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingRepository extends JpaRepository<Training, UUID> {
}
