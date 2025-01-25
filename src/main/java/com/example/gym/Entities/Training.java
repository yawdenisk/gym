package com.example.gym.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "trinings")
public class Training {
    @Id
    @UuidGenerator
    public UUID id;
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;
}
