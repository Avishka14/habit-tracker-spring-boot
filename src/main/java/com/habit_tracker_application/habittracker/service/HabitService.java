package com.habit_tracker_application.habittracker.service;

import com.habit_tracker_application.habittracker.model.Habit;
import com.habit_tracker_application.habittracker.model.HabitLog;
import com.habit_tracker_application.habittracker.repository.HabitRepository;
import com.habit_tracker_application.habittracker.repository.HabitLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HabitService {
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private HabitLogRepository habitLogRepository;

    public Habit createHabit(Habit habit) {
        habit.setStreak(0);
        habit.setTotalDays(0);
        habit.setCompletedDays(0);
        return habitRepository.save(habit);
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Optional<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    public Habit updateHabit(Long id, Habit habit) {
        Habit existingHabit = habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
        existingHabit.setName(habit.getName());
        existingHabit.setDescription(habit.getDescription());
        return habitRepository.save(existingHabit);
    }

    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }

    public HabitLog logHabit(Long habitId, HabitLog log) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        log.setHabit(habit);
        log.setDate(LocalDate.now());


        List<HabitLog> yesterdayLog = habitLogRepository.findByHabitIdAndDate(habitId, LocalDate.now().minusDays(1));
        habit.setTotalDays(habit.getTotalDays() + 1);
        if (log.isCompleted()) {
            habit.setCompletedDays(habit.getCompletedDays() + 1);
            habit.setStreak(yesterdayLog.stream().anyMatch(HabitLog::isCompleted) ? habit.getStreak() + 1 : 1);
        } else {
            habit.setStreak(0);
        }
        habitRepository.save(habit);
        return habitLogRepository.save(log);
    }

    public String getHabitStats(Long id) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
        double completionRate = habit.getTotalDays() > 0
                ? (double) habit.getCompletedDays() / habit.getTotalDays() * 100
                : 0;
        return String.format("Habit: %s\nCurrent Streak: %d days\nCompletion Rate: %.2f%%\nTotal Days: %d\nCompleted Days: %d",
                habit.getName(), habit.getStreak(), completionRate, habit.getTotalDays(), habit.getCompletedDays());
    }
}
