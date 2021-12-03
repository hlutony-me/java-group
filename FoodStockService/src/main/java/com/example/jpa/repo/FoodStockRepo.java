package com.example.jpa.repo;


import com.example.jpa.model.FoodStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodStockRepo extends JpaRepository<FoodStock, Long> {
}
