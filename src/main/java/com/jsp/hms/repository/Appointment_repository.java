package com.jsp.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hms.entitty.Appointments;

public interface Appointment_repository extends JpaRepository<Appointments, Integer> {

}
