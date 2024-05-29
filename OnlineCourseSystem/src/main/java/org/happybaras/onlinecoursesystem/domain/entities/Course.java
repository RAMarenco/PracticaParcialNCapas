package org.happybaras.onlinecoursesystem.domain.entities;

import com.sun.java.accessibility.util.GUIInitializedListener;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "happy_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @ManyToOne(optional = false)
    private User owner;
}
