package com.example.fitnesstracker.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user_statistics")
@Data
@NoArgsConstructor
public class UserStatistics {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int totalWorkouts;

  private double totalCaloriesBurned;

  private double totalDistanceRan;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;


}