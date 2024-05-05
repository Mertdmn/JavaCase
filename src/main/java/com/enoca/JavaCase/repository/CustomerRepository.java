package com.enoca.JavaCase.repository;

import com.enoca.JavaCase.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
