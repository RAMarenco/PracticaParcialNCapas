package org.happybaras.onlinecoursesystem.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "happy_user_course")
@Data
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date begin_date;
    private Date end_date;
    private boolean finished;

    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private Course course;

}
