package com.example.gym.Repositories;

import com.example.gym.Entities.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GymRepository extends JpaRepository<Gym, UUID> {
}
