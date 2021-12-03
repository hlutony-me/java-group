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
@Table(name="food_stock")
public class FoodStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Food Stock Type is mandatory")
    private String foodGroup;

    @NotBlank(message = "Food Quantity is mandatory")
    private String quantity;

    @NotBlank(message = "Food best before is mandatory")
    private String bestBefore;


    public void setId(Long id) {
        this.id = id;
    }


}
