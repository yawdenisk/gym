package com.example.gym.Entities;

import jakarta.persistence.*;
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
@Table(name = "coaches")
public class Coach {
    @Id
    @UuidGenerator
    public UUID id;
    public String name;
    public String surname;
    @OneToMany(mappedBy = "coach")
    private List<Training> trainings;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
}
