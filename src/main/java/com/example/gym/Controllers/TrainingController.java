package com.example.gym.Controllers;

import com.example.gym.Entities.Training;
import com.example.gym.Handlers.TrainingNotFoundException;
import com.example.gym.Services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/training")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;
    @PostMapping("/reserve")
    public ResponseEntity<?> reserveTraining(@RequestBody Training training) {
        try{
            trainingService.reserve(training);
            return ResponseEntity.ok().body("Training reserved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Training reservation failed");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTraining(@PathVariable UUID id) {
        Training training = trainingService.get(id).orElseThrow(() -> new TrainingNotFoundException());
        return ResponseEntity.ok().body(training);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTraining(@PathVariable UUID id) {
        try{
            trainingService.delete(id);
            return ResponseEntity.ok().body("Training deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Training deletion failed");
        }
    }
}
