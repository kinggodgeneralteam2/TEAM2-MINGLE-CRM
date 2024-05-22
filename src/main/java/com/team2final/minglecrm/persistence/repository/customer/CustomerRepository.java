package com.team2final.minglecrm.persistence.repository.customer;

import com.team2final.minglecrm.entity.customer.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByEmployeeName(String employeeName);

    List<Customer> findByCustomerGroup(String customerGroup);
}
