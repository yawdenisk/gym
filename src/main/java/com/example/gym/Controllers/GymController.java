package com.example.gym.Controllers;

import com.example.gym.Entities.Gym;
import com.example.gym.Handlers.GymNotFoundException;
import com.example.gym.Services.GymServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/gym")
public class GymController {
    @Autowired
    private GymServise gymServise;
    @PostMapping("/add")
    public ResponseEntity<?> addGym(@RequestBody Gym gym) {
        try{
            gymServise.addGym(gym);
            return ResponseEntity.ok().body("Gym added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error adding gym");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getGymById(@PathVariable("id") UUID id) {
        Gym gym = gymServise.getGym(id).orElseThrow(()-> new GymNotFoundException());
        return ResponseEntity.ok().body(gym);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateGym(@PathVariable("id") UUID id, @RequestBody Gym gym) {
        try{
            gymServise.updateGym(id, gym);
            return ResponseEntity.ok().body("Gym updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating gym");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGym(@PathVariable("id") UUID id) {
        try{
            gymServise.deleteGym(id);
            return ResponseEntity.ok().body("Gym deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting gym");
        }
    }
}
