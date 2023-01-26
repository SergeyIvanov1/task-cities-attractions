package com.ivanov_sergey.spring.taskcitiesattractions.dao;

import com.ivanov_sergey.spring.taskcitiesattractions.model.Attraction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {
//    Optional<User> findByEmail(String email);
//    Optional<User> findByUsername(String username);

    Page<Attraction> findAll(Pageable pageable);
//    Page<Attraction> findAllByCity(String CityName, Pageable pageable);

}
