package com.example.jpa.controller;


import com.example.jpa.model.FoodStock;
import com.example.jpa.repo.FoodStockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/food-stock")
public class FoodStockController {
    @Autowired
    FoodStockRepo foodStockRepo;

    @GetMapping("")
    public String showAll(Model model) {
        List<FoodStock> banks = foodStockRepo.findAll();

        model.addAttribute("foodStocks", banks);
        return "food-stock/stock-list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        FoodStock stock = foodStockRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id:" + id));

        model.addAttribute("foodStock", stock);
        return "food-stock/edit-stock";
    }

    //update the existing department info
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long no, @Valid FoodStock foodStock,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            foodStock.setId(no);
            return "food-stock/edit-stock";
        }

        foodStockRepo.save(foodStock);
        model.addAttribute("foodStocks", foodStockRepo.findAll());
        return "food-stock/stock-list";
    }

    @GetMapping("/add-page")
    public String add(FoodStock foodStock){
        return "food-stock/add-stock";
    }

    //update the existing department info
    @PostMapping("/add")
    public String update( @Valid FoodStock foodStock,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "food-stock/add-stock";
        }
        foodStockRepo.save(foodStock);
        model.addAttribute("foodStocks", foodStockRepo.findAll());
        return "food-stock/stock-list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        foodStockRepo.deleteById(id);
        model.addAttribute("foodStocks", foodStockRepo.findAll());
        return "food-stock/stock-list";
    }

}
