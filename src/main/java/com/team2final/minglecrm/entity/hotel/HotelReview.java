package com.team2final.minglecrm.entity.hotel;


import com.team2final.minglecrm.entity.customer.Customer;
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
public class HotelReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double kindnessRating;
    private Double clearlinessRating;
    private Double convenienceRating;
    private Double locationRating;
    private String comment;
    private Customer customer;
    private RoomReservation roomReservation;


}
