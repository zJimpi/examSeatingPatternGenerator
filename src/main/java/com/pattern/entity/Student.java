package com.pattern.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {

    @Id // primary key for the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the primary key value to be auto generated 
    private int classRoll; // Custom methods to insert the roll

    @Column(length = 4, nullable = true) 
    private int uniRoll;//university roll

    @Column(length = 30, nullable = false) // Specifies column attributes in the database table.
    private String stdName;//student name

    @Column(length = 10, nullable = false, unique = true)
    private String stdPhNo;// student phone number

    @Column(length = 20, nullable = false, unique = true)
    private String stdEmail;//student email

    @ManyToOne // Defines a many-to-one relationship with the Department entity.
    private Department department;

    @ManyToMany // Defines a many-to-many relationship with the Subject entity.
    private List<Subject> subjects;
}