package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.service.city.ICityService;
import com.codegym.service.national.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    INationService nationService;
    @Autowired
    ICityService cityService;

    @GetMapping("/")
    public ModelAndView home(Model model) {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }

    @GetMapping(value = "/createcity")
    public ModelAndView createCity() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping(value = "/createcity")
    public String postCreate(@ModelAttribute("city") City city, Model model) {
        if (city != null) {
            cityService.save(city);
            model.addAttribute("message", "thềm thành công ");
        }
        return "/create";
    }


    @GetMapping(value = "/edit/city/{id}")
    public String editCity(@PathVariable Long id, Model model) {
        Optional<City> city = cityService.findById(id);
        if (city != null) {
            model.addAttribute("nations", nationService.findAll());
            model.addAttribute("city", city);
            return "/edit";
        }
        model.addAttribute("city", new City());
        model.addAttribute("nations", nationService.findAll());
        return "/edit";
    }


    @GetMapping(value = "delete/city/{id}")
    public String deleteCity(@PathVariable Long id, Model model){
        cityService.remove(id);
        return "/delete";
    }

    @GetMapping(value = "/view/city/{id}")
    public String viewCity(@PathVariable Long id, Model model) {
        model.addAttribute("city",cityService.findById(id));
        return "/view";
    }
}
