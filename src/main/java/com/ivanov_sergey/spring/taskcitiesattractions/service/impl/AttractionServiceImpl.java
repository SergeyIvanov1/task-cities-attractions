package com.ivanov_sergey.spring.taskcitiesattractions.service.impl;

import com.ivanov_sergey.spring.taskcitiesattractions.dao.AttractionRepository;
import com.ivanov_sergey.spring.taskcitiesattractions.model.Attraction;
import com.ivanov_sergey.spring.taskcitiesattractions.service.AttractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AttractionServiceImpl implements AttractionService {

    private final AttractionRepository attractionRepository;

    @Autowired
    public AttractionServiceImpl(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @Override
    public Page<Attraction> findAllAttractions(Pageable pageable) {
        Page<Attraction> page = attractionRepository.findAll(pageable);
        log.info("IN findAllAttractions - {} attractions found", page.getSize());
        return page;
    }

//    public Page<Attraction> findAttractionsByCity(String cityName, Pageable pageable) {
//        Page<Attraction> page = attractionRepository.findAllByCity(cityName, pageable);
//        log.info("IN findByCityName - {} attractions found by city name: {}", cityName, page.getSize());
//        return page;
//    }

    @Override
    public void addAttraction(Attraction attraction) {
        attractionRepository.save(attraction);
        log.info("IN addAttraction - attraction: {} successfully added", attraction);
    }

    @Override
    public void delete(Long id) {
        attractionRepository.deleteById(id);
        log.info("IN delete - attraction with id: {} successfully deleted", id);
    }
//    private final AttractionMapper attractionMapper;

//    public AttractionServiceImpl(AttractionRepository attractionRepository, AttractionMapper attractionMapper) {
//        this.attractionRepository = attractionRepository;
//        this.attractionMapper = attractionMapper;
//    }

//    @Override
//    public PageDTO<AttractionDTO> getAllAttractions(int page, int size, String sortBy) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        Page<AttractionDTO> attractionDTOS = attractionRepository.findAll(pageable)
//                .map(attractionMapper::mapToDto);
//        return new PageDTO<>(attractionDTOS, pageable);
//    }
}
