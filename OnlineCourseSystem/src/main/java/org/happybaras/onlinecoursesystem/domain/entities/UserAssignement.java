package org.happybaras.onlinecoursesystem.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "happy_userassignement")
public class UserAssignement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date submit_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;
}
