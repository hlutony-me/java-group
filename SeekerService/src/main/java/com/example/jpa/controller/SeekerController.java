package com.example.jpa.controller;


import com.example.jpa.model.Seeker;

import com.example.jpa.repo.SeekerRepo;
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
@RequestMapping("/seeker")
public class SeekerController {
    @Autowired
    SeekerRepo seekerRepo;

    @GetMapping("")
    public String showAll(Model model) {
        List<Seeker> seekers = seekerRepo.findAll();

        model.addAttribute("seekers", seekers);
        return "seeker/seeker-list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Seeker seeker = seekerRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid seeker id:" + id));

        model.addAttribute("seeker", seeker);
        return "seeker/edit-seeker";
    }

    //update the existing department info
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long no, @Valid Seeker seeker,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            seeker.setId(no);
            return "seeker/edit-seeker";
        }

        seekerRepo.save(seeker);
        model.addAttribute("seekers", seekerRepo.findAll());
        return "seeker/seeker-list";
    }

    @GetMapping("/add-page")
    public String add(Seeker seeker){
        return "seeker/add-seeker";
    }

    //update the existing department info
    @PostMapping("/add")
    public String update( @Valid Seeker seeker,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "seeker/add-seeker";
        }
        seekerRepo.save(seeker);
        model.addAttribute("seekers", seekerRepo.findAll());
        return "seeker/seeker-list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        seekerRepo.deleteById(id);
        model.addAttribute("seekers", seekerRepo.findAll());
        return "seeker/seeker-list";
    }

}
