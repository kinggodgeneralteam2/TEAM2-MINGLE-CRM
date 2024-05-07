package com.team2final.minglecrm.domain;


import com.team2final.minglecrm.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="customer")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    private String name;
    private String customer_group;
    private String phone;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String memo;
    private String gender;
    private LocalDate birth;

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomer_group(String customer_group) {
        this.customer_group = customer_group;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
