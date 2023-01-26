package com.ivanov_sergey.spring.taskcitiesattractions.model;

import com.ivanov_sergey.spring.taskcitiesattractions.enums.AttractionType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "attractions")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Attraction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "attraction_name", length = 100, nullable = false)
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё0-9+_ .-]{2,100}",
            message = "Name of attraction must contain only letters, numbers and be between 2 and 100 characters long")
    private String attractionName;

    @Column(name = "date_building")
    @Temporal(TemporalType.DATE)
    private Date dateBuilding;

    @Column(name = "short_description", length = 255, nullable = false)
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё0-9+_ .-]{2,255}",
            message = "Short description must contain only letters, numbers and be between 2 and 255 characters long")
    private String shortDescription;

    @Column(name = "attraction_type", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private AttractionType attractionType;

    @Column(name = "city_id")
    private int cityId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return cityId == that.cityId
                && Objects.equals(id, that.id)
                && Objects.equals(attractionName, that.attractionName)
                && Objects.equals(dateBuilding, that.dateBuilding)
                && Objects.equals(shortDescription, that.shortDescription)
                && attractionType == that.attractionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attractionName, dateBuilding, shortDescription, attractionType, cityId);
    }

    //    @ManyToOne
//    @JoinColumn(name = "city_id")
//    private City city;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Attraction that = (Attraction) o;
//        return Objects.equals(id, that.id)
//                && Objects.equals(attractionName, that.attractionName)
//                && Objects.equals(dateBuilding, that.dateBuilding)
//                && Objects.equals(shortDescription, that.shortDescription)
//                && attractionType == that.attractionType
//                && Objects.equals(city, that.city);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, attractionName, dateBuilding, shortDescription, attractionType, city);
//    }
}
