package com.jsp.hms.service;

import com.jsp.hms.entitty.Appointments;
import com.jsp.hms.entitty.Customer;
import com.jsp.hms.entitty.Services;
import com.jsp.hms.entitty.Workers;

public interface Is_HairSaloon_Service {

	Workers addWorker(Workers worker);

	Customer isAddCustomerr(Customer customer);

	Services isAddService(Services servi,int customerId,int workerId, int appointmentId);

	Appointments isAddAppointment(Appointments appointment);

}
