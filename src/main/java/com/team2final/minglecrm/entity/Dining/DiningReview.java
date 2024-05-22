package com.team2final.minglecrm.entity.Dining;

import com.team2final.minglecrm.entity.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    private Double tasteRating;
    private Double kindnessRating;
    private Double clearlinessRating;
    private Double atmosphereRating;

    private String review;

    private Customer customer;

    private DishReservation dishReservation;

}
