package com.example.gym.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "karnet")
public class Karnet {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private Float price;
    private enum Status {};
    @OneToOne
    private User user;
}
