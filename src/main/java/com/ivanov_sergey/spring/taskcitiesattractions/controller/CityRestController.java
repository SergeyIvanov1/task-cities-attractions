package com.ivanov_sergey.spring.taskcitiesattractions.controller;

import com.ivanov_sergey.spring.taskcitiesattractions.model.Attraction;
import com.ivanov_sergey.spring.taskcitiesattractions.model.City;
import com.ivanov_sergey.spring.taskcitiesattractions.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/cities")
public class CityRestController {

    private final CityService cityService;

    @Autowired
    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city/{id}/attractions")
    public Set<Attraction> getAttractionsOfCity(@PathVariable Long id){
        City city = cityService.getCity(id);
        return city.getAttractions();
    }

    @PostMapping("/city")
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }

    @PutMapping("/city")
    public City updateCity(@RequestBody City city){
        cityService.addCity(city);
        return city;
    }
}
