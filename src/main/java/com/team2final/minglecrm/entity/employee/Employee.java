package com.team2final.minglecrm.entity.employee;


import com.team2final.minglecrm.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    private String name;

    private String email;
    private String password;
    private String authority;

    private LocalDateTime createdDate;
    private Boolean vaildYn;
    private Boolean deletedYn;

    @Builder
    public Employee(String name, String email, String password, String authority,
            Boolean deletedYn) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.authority = authority;
        this.deletedYn = deletedYn;
    }

    public void setName(String name) {
        this.name = name;
    }
}
