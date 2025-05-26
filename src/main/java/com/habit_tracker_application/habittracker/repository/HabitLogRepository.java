package com.habit_tracker_application.habittracker.repository;

import com.habit_tracker_application.habittracker.model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {
    List<HabitLog> findByHabitIdAndDate(Long habitId, LocalDate date);
}