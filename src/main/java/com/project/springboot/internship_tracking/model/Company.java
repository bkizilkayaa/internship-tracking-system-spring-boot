package com.project.springboot.internship_tracking.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "company")
public class Company {
    @Id
    private Integer id;

    private String companyName;
}
