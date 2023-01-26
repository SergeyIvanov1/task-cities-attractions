package com.ivanov_sergey.spring.taskcitiesattractions.controller;

import com.ivanov_sergey.spring.taskcitiesattractions.model.Attraction;
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

//    @GetMapping("")
//    public ResponseEntity<PageDTO<AttractionDTO>> getAllAttractions(
//            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
//            @RequestParam(value = "size", required = false, defaultValue = "${default.pageSize}") int size,
//            @RequestParam(value = "sort", required = false, defaultValue = "${attraction.sortBy}") String sortBy) {
//        return new ResponseEntity<>(attractionService.getAllAttractions(page, size, sortBy), HttpStatus.OK);
//    }

    @GetMapping("")
    public Page<Attraction> showAllAttractions(@PageableDefault(sort = {"attractionName"})Pageable pageable){
        return attractionService.findAllAttractions(pageable);
    }

//    @GetMapping("")
//    public Page<Attraction> showAllAttractionByCity(String cityName, Pageable pageable){
//        return attractionService.findAttractionsByCity(cityName, pageable);
//    }

    @PostMapping("/attraction")
    public Attraction addAttraction(@RequestBody Attraction attraction){
        attractionService.addAttraction(attraction);
        return attraction;
    }

    @DeleteMapping("/{id}")
    public void deleteAttraction(@PathVariable Long id){
        attractionService.delete(id);
    }
}
