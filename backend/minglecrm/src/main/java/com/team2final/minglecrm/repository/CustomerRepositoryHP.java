package com.team2final.minglecrm.repository;

import com.team2final.minglecrm.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositoryHP extends JpaRepository<Customer, Long> {

    List<Customer> findByUserName(String username);

    @Query("SELECT c FROM Customer c WHERE c.customer_group = :customerGroup")
    List<Customer> findByCustomer_group(String customerGroup);


}
