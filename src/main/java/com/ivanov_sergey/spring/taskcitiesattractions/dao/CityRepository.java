package com.ivanov_sergey.spring.taskcitiesattractions.dao;

import com.ivanov_sergey.spring.taskcitiesattractions.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
//    Optional<User> findByEmail(String email);
//    Optional<User> findByUsername(String username);
}
