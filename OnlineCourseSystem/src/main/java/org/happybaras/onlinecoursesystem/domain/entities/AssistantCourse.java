package org.happybaras.onlinecoursesystem.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Table(name = "happy_assistant_course")
@Entity
public class AssistantCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    private User assistant;
    @ManyToOne(optional = false)
    private Course course;
}
