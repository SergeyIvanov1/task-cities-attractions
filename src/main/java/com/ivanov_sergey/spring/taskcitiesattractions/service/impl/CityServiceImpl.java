package com.ivanov_sergey.spring.taskcitiesattractions.service.impl;

import com.ivanov_sergey.spring.taskcitiesattractions.repository.CityRepository;
import com.ivanov_sergey.spring.taskcitiesattractions.exception_handling.NoSuchEntityException;
import com.ivanov_sergey.spring.taskcitiesattractions.model.City;
import com.ivanov_sergey.spring.taskcitiesattractions.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City getCity(Long id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        City city;
        if (optionalCity.isPresent()){
            city = optionalCity.get();
        } else {
            throw new NoSuchEntityException("There is no city with ID = " + id + " in the DataBase");
        }
        return city;
    }
    @Override
    public City addCity(City city) {
        cityRepository.save(city);
        log.info("IN addCity - city {} successfully added", city);
        return city;
    }
}
