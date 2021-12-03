package com.example.jpa.controller;


import com.example.jpa.model.FoodBank;
import com.example.jpa.repo.FoodBankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/food-bank")
public class FoodBankController {
    @Autowired
    FoodBankRepo foodBankRepo;

    @GetMapping("")
    public String showAll(Model model) {
        List<FoodBank> banks = foodBankRepo.findAll();

        model.addAttribute("foodBanks", banks);
        return "food-bank/bank-list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        FoodBank bank = foodBankRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid department number:" + id));

        model.addAttribute("foodBank", bank);
        return "food-bank/edit-bank";
    }

    //update the existing department info
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long no, @Valid FoodBank foodBank,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            foodBank.setId(no);
            return "food-bank/edit-bank";
        }

        foodBankRepo.save(foodBank);
        model.addAttribute("foodBanks", foodBankRepo.findAll());
        return "food-bank/bank-list";
    }

    @GetMapping("/add-page")
    public String add(FoodBank foodBank){
        return "food-bank/add-bank";
    }

    //update the existing department info
    @PostMapping("/add")
    public String update( @Valid FoodBank foodBank,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "food-bank/add-bank";
        }
        foodBankRepo.save(foodBank);
        model.addAttribute("foodBanks", foodBankRepo.findAll());
        return "food-bank/bank-list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        foodBankRepo.deleteById(id);
        model.addAttribute("foodBanks", foodBankRepo.findAll());
        return "food-bank/bank-list";
    }

}
