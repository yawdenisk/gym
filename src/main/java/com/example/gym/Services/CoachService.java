package com.example.gym.Services;

import com.example.gym.Entities.Coach;
import com.example.gym.Handlers.CoachNotFoundException;
import com.example.gym.Repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoachService {
    @Autowired private CoachRepository coachRepository;

    public void addCoach(Coach coach) {
        coachRepository.save(coach);
    }

    public Optional<Coach> getCoach(UUID id) {
        return coachRepository.findById(id);
    }

    public void update(UUID id, Coach coach) {
        Coach oldCoach = coachRepository.findById(id).orElseThrow(() -> new CoachNotFoundException());
        oldCoach.setName(coach.getName());
        oldCoach.setSurname(coach.getSurname());
        oldCoach.setGym(coach.getGym());
        coachRepository.save(oldCoach);
    }

    public void deleteCoach(UUID id) {
        coachRepository.deleteById(id);
    }

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }
}
