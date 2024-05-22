package com.team2final.minglecrm.entity.hotel;

import com.team2final.minglecrm.entity.customer.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private HotelRoom hotelRoom;
    private Payment payment;
    private Customer customer;

    private LocalDateTime reservationDate;
    private LocalDateTime checkinTime;
    private LocalDateTime checkoutTime;
    private Long price;
}
