package com.habit_tracker_application.habittracker.repository;

import com.habit_tracker_application.habittracker.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {
}