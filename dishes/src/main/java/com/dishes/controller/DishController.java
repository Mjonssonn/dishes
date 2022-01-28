package com.dishes.controller;

import com.dishes.entity.Dish;
import com.dishes.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @PostMapping("/save-dish")
    public String saveDish(@ModelAttribute("dish") Dish dish) {
        dishRepository.save(dish);
        return "redirect:/index";
    }

    @GetMapping("/get-dish/{id}")
    public Dish getDish(@PathVariable("id") String dishId, Model model) {
        Dish dish = dishRepository.getDishById(dishId);
        model.addAttribute("dish", dish);
        return dishRepository.getDishById(dishId);
    }

    @GetMapping("/index")
    public String findAllDishes(@ModelAttribute("dish") Dish dish, Model model) {
        List<Dish> dishes = dishRepository.findAllDishes();
        model.addAttribute("dishes", dishes);
        return "index";
    }


    @GetMapping("/delete-dish/{id}")
    public String deleteDish(@PathVariable("id") String dishId, Model model) {
        Dish dish = dishRepository.getDishById(dishId);
        dishRepository.delete(dishId);
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete_user/{personId}", method = RequestMethod.GET)
    public String handleDeleteUser(@PathVariable String personId) {
        System.out.println(personId);
        System.out.println("test");
        return "redirect:/external";
    }

    @GetMapping("/update-dish/{id}")
    public String updateDish(@PathVariable("id") String dishId, Model model) {
        Dish dish = dishRepository.getDishById(dishId);
        model.addAttribute("dish", dish);
        return "update.html";
    }


    @PostMapping("/update-dish/{id}")
    public String updateDish(@PathVariable("id") String id, Dish dish, BindingResult result, Model model) {
        if (result.hasErrors()) {
            dish.setDishId(id);
            return "update.html";
        }
        dishRepository.save(dish);
        return "redirect:/index";
    }

}
