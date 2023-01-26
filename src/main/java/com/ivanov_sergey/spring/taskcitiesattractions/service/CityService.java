package com.ivanov_sergey.spring.taskcitiesattractions.service;


import com.ivanov_sergey.spring.taskcitiesattractions.model.City;

public interface CityService {
    City addCity(City city);

    City getCity(Long id);
}
