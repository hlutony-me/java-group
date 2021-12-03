package com.example.jpa.repo;

import com.example.jpa.model.FoodBank;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodBankRepo extends JpaRepository<FoodBank, Long> {
}
