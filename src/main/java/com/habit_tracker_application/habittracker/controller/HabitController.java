package com.habit_tracker_application.habittracker.controller;

import com.habit_tracker_application.habittracker.model.Habit;
import com.habit_tracker_application.habittracker.model.HabitLog;
import com.habit_tracker_application.habittracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {
    @Autowired
    private HabitService habitService;

    @PostMapping
    public Habit createHabit(@RequestBody Habit habit) {
        return habitService.createHabit(habit);
    }

    @GetMapping
    public List<Habit> getAllHabits() {
        return habitService.getAllHabits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habit> getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long id, @RequestBody Habit habit) {
        return ResponseEntity.ok(habitService.updateHabit(id, habit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/log")
    public HabitLog logHabit(@PathVariable Long id, @RequestBody HabitLog log) {
        return habitService.logHabit(id, log);
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<String> getHabitStats(@PathVariable Long id) {
        return ResponseEntity.ok(habitService.getHabitStats(id));
    }
}