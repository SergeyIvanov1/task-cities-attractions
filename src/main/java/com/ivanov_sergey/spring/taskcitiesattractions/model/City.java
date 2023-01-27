package com.ivanov_sergey.spring.taskcitiesattractions.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cities")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_name", length = 50, nullable = false)
    private String cityName;

    @Column(name = "population", nullable = false)
    private int population;

    @Column(name = "is_subway")
    private boolean isSubway;

    @Column(name = "country", length = 50, nullable = false)
    private String country;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private Set<Attraction> attractions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population
                && isSubway == city.isSubway
                && Objects.equals(id, city.id)
                && Objects.equals(cityName, city.cityName)
                && Objects.equals(country, city.country)
                && Objects.equals(attractions, city.attractions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, population, isSubway, country, attractions);
    }
}
