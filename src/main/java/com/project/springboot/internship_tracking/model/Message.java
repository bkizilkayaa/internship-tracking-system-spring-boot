package com.project.springboot.internship_tracking.model;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lecturer_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Lecturer lecturer;

    @Column
    private String title;

    @Column
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}
