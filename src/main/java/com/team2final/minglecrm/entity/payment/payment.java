package com.team2final.minglecrm.entity.payment;

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
public class payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    private String type;
    private Long amount_before_discount;
    private Long discount_amount;
    private Long payment_amount;
    private LocalDateTime payment_date;
    private Boolean refund_yn;
    private LocalDateTime refund_date;
    private Long created_reward;

    private int customer_id;

    private String payment_spot;








}
