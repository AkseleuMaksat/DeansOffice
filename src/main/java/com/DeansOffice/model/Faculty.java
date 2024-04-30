package com.DeansOffice.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_faculty")
@Getter
@Setter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facultyId")
    private Long facultyId;

    @Column(name = "facultyName", length = 255)
    private String facultyName;

    @Column(name = "dean", length = 100)
    private String dean;

}

