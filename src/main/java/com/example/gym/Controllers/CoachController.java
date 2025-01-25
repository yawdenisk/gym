package com.example.gym.Controllers;

import com.example.gym.Entities.Coach;
import com.example.gym.Handlers.CoachNotFoundException;
import com.example.gym.Services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/coach")
public class CoachController {
    @Autowired private CoachService coachService;
    @PostMapping("/add")
    public ResponseEntity<?> addCoach(@RequestBody Coach coach) {
        try{
            coachService.addCoach(coach);
            return ResponseEntity.ok().body("Coach added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Coach could not be added");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCoach(@PathVariable UUID id) {
        Coach coach = coachService.getCoach(id).orElseThrow(()-> new CoachNotFoundException());
        return ResponseEntity.ok().body(coach);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCoach(@PathVariable UUID id, @RequestBody Coach coach) {
        try{
            coachService.update(id, coach);
            return ResponseEntity.ok().body("Coach updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Coach could not be updated");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCoach(@PathVariable UUID id) {
        try{
            coachService.deleteCoach(id);
            return ResponseEntity.ok().body("Coach deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Coach could not be deleted");
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCoach() {
        try{
            List<Coach> coaches = coachService.getAllCoaches();
            return ResponseEntity.ok().body(coaches);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Coach could not be retrieved");
        }
    }
}
