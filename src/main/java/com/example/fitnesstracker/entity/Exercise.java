package com.example.fitnesstracker.entity;

import com.example.fitnesstracker.enumeration.ExerciseType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exercises")
@Data
@NoArgsConstructor
public class Exercise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private double durationInMinutes;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ExerciseType type;

  @Column(nullable = false)
  private double value;

  @Column(length = 1000)
  private String instructions;

  @ManyToMany(mappedBy = "exercises")
  private List<Workout> workouts;

}