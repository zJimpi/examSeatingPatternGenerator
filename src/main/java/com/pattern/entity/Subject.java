package com.pattern.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class Subject {

    @Id // primary key for the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies how the primary key value is generated (auto-increment in this case).
    private int subId; // subject id

    @Column(length = 30, nullable = false) 
    private String subName; // Name of the subject.

    @Column(nullable = true) 
    private LocalDate examDate; // Date of the subject's exam.

    @ManyToOne // Defines a many-to-one relationship with the Department entity.
    private Department department; // Department to which the subject belongs.

    @ManyToMany // Defines a many-to-many relationship with the Student entity.
    private List<Student> students; // List of students enrolled in this subject.
}
