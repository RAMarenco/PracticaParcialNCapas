package org.happybaras.onlinecoursesystem.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.java.accessibility.util.GUIInitializedListener;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
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

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @JsonIgnore // Para evitar el bucle infinito que genera la librería de Jackson
    private List<User> users;

}
