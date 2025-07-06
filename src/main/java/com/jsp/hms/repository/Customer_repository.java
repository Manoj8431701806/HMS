package com.jsp.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hms.entitty.Customer;

public interface Customer_repository extends JpaRepository<Customer, Integer> {

}
