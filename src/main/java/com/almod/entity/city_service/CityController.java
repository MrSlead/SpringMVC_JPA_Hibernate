package com.almod.entity.city_service;

import com.almod.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("/")
    public ModelAndView home() {
        List<City> listCity = cityService.findAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listCity", listCity);
        return mav;
    }

    @RequestMapping("/new")
    public String newCity(ModelMap model){
        City city = new City();
        model.put("city", city);
        return "new_city";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCity(@ModelAttribute("city") City city){
        cityService.save(city);
        return "redirect:/";
    }

}
