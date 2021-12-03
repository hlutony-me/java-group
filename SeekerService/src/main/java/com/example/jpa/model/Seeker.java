package com.example.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="seeker")
public class Seeker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Seeker First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Seeker Last Name is mandatory")
    private String lastName;

    private int age;

    private String gender;
    private String city;

    public void setId(Long id) {
        this.id = id;
    }

    private String phone;
}
