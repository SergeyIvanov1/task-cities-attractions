package com.ivanov_sergey.spring.taskcitiesattractions.controller;

import com.ivanov_sergey.spring.taskcitiesattractions.model.Attraction;
import com.ivanov_sergey.spring.taskcitiesattractions.model.City;
import com.ivanov_sergey.spring.taskcitiesattractions.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/attractions")
public class AttractionRestController {

        private final AttractionService attractionService;

    @Autowired
    public AttractionRestController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping("")
    public Page<Attraction> showAllAttractions(@PageableDefault(sort = {"attractionName"})Pageable pageable){
        return attractionService.findAllAttractions(pageable);
    }

    @PostMapping("/attraction")
    public Attraction addAttraction(@RequestBody Attraction attraction){
        attractionService.addAttraction(attraction);
        return attraction;
    }

    @PutMapping("/attraction")
    public Attraction updateCity(@RequestBody Attraction city){
        attractionService.addAttraction(city);
        return city;
    }

    @DeleteMapping("/{id}")
    public void deleteAttraction(@PathVariable Long id){
        attractionService.delete(id);
    }
}
