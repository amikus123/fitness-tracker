package com.example.fitnesstracker.entity;

import com.example.fitnesstracker.enumeration.GoalType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "fitness_goals")
@Data
@NoArgsConstructor
public class FitnessGoal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private GoalType goalType;

  @Column(nullable = false)
  private double targetValue;

  @Column(nullable = false)
  private double currentValue;

  @Column(nullable = false)
  private LocalDate deadline;

  @Column(nullable = true)
  private LocalDate finishedAt;

  @Column(nullable = false)
  private LocalDate createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}