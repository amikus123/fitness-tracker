package com.example.fitnesstracker.entity;

import com.example.fitnesstracker.enumeration.AchievementType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "achievements")
@Data
@NoArgsConstructor
public class Achievement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(length = 1000)
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AchievementType type;


  @Column(nullable = false)
  private double targetValue;


  @OneToMany(fetch = FetchType.LAZY)
  private Set<AchievementProgress>   achievementProgresses = new HashSet<>();

}