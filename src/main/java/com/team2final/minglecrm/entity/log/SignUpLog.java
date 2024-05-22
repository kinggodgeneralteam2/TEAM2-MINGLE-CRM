package com.team2final.minglecrm.entity.log;

import com.team2final.minglecrm.entity.employee.Employee;
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
public class SignUpLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    private Employee employee;

    private String name;

    private String email;

    private String password;

    private String authority;

    private LocalDateTime requestDate;

    private Boolean approvalYn;

    private LocalDateTime authorityChangeDate;

    private Boolean deleteYn;

    private LocalDateTime deleteDate;


}
