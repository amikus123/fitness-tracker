package com.example.fitnesstracker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "workout_progress")
@Data
@NoArgsConstructor
public class WorkoutProgress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private double durationInMinutes;

  @Column(nullable = false)
  private int caloriesBurned;

  @Column(nullable = false)
  private LocalDate startedAt;

  @Column(nullable = true)
  private LocalDate finishedAt;

  @Column(nullable = false)
  private int distanceRan;

  @ElementCollection
  @CollectionTable(name = "workout_progress_exercises", joinColumns = @JoinColumn(name = "workout_progress_id"))
  @Column(name = "exercise_done")
  private List<Long> exercisesDone;


  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "workout_id", nullable = false)
  private Workout workout;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

}