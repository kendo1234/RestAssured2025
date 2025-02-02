package com.example.dragonballPowerLevel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dragonball")
public class controller {

    private final Map<String, String> dragonBallData = new HashMap<>();

    public controller() {
        dragonBallData.put("character", "Goku");
        dragonBallData.put("powerLevel", "Over 9000!");
    }

    @GetMapping("/data")
    public ResponseEntity<Map<String, String>> getData() {
        return ResponseEntity.ok(dragonBallData);
    }

    @PostMapping("/data")
    public ResponseEntity<Map<String, String>> postData(@RequestBody Map<String, String> requestBody) {
        String character = requestBody.get("character");
        String powerLevel = requestBody.get("powerLevel");
        dragonBallData.put("character", character);
        dragonBallData.put("powerLevel", powerLevel);

        return ResponseEntity.ok(Collections.singletonMap("message", character + " has a power level of " + powerLevel));
    }

    @PutMapping("/data")
    public ResponseEntity<Map<String, String>> updateData(@RequestBody Map<String, String> requestBody) {
        String character = requestBody.getOrDefault("character", dragonBallData.get("character"));
        String powerLevel = requestBody.getOrDefault("powerLevel", dragonBallData.get("powerLevel"));

        dragonBallData.put("character", character);
        dragonBallData.put("powerLevel", powerLevel);

        return ResponseEntity.ok(Collections.singletonMap("message", character + "'s power level has been updated to " + powerLevel));
    }

    @DeleteMapping("/data")
    public ResponseEntity<Map<String, String>> deleteData() {
        dragonBallData.clear();
        return ResponseEntity.ok(Collections.singletonMap("message", "The Dragon Ball character data has been erased!"));
    }
}
