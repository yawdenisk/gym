package com.example.gym.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "gyms")
public class Gym {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "gym")
    private List<Coach> coaches;
    @OneToMany(mappedBy = "gym")
    private List<Training> trainings;
}
