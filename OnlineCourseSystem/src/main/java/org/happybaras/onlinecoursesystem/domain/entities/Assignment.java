package org.happybaras.onlinecoursesystem.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "happy_assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Course courseId;

    private String assignment;
    private String description;
    private String deadline;
    private String tries;
    private Float score;
}
