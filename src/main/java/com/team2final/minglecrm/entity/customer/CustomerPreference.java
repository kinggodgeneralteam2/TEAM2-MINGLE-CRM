package com.team2final.minglecrm.entity.customer;

import jakarta.persistence.Column;
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
public class CustomerPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private Customer customer;

    private Boolean smokingYn;
    private String purpose;
    private Boolean petYn;
    private LocalDateTime preferredCheckinTime;
    private LocalDateTime preferredCheckoutTime;
    private String dietaryRestrictions;
    private String funnel;
    private String interest;
    private Boolean isBreakfastPreferred;

}

