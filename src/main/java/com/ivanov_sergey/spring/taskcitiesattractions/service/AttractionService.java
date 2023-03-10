package com.ivanov_sergey.spring.taskcitiesattractions.service;

import com.ivanov_sergey.spring.taskcitiesattractions.enums.AttractionType;
import com.ivanov_sergey.spring.taskcitiesattractions.model.Attraction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttractionService {

    void addAttraction(Attraction attraction);
    Page<Attraction> findAllAttractions(Pageable pageable);
    void delete(Long id);
}
