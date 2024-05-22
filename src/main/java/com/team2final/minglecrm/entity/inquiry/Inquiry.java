package com.team2final.minglecrm.entity.inquiry;

import com.team2final.minglecrm.entity.customer.Customer;
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
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    private Customer customer;

    private LocalDateTime date;

    private String inquiry;

    private String type;

    private Boolean replyYn;

    private Boolean actionRequestYn;

    private String actionContent;

}
