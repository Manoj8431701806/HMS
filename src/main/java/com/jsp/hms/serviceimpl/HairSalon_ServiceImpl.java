package com.jsp.hms.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.hms.entitty.Appointments;
import com.jsp.hms.entitty.Customer;
import com.jsp.hms.entitty.Services;
import com.jsp.hms.entitty.Workers;
import com.jsp.hms.repository.Appointment_repository;
import com.jsp.hms.repository.Customer_repository;
import com.jsp.hms.repository.HairSaloon_Repository;
import com.jsp.hms.repository.Service_repository;
import com.jsp.hms.service.Is_HairSaloon_Service;
@Service
public class HairSalon_ServiceImpl implements Is_HairSaloon_Service {
	@Autowired
	private HairSaloon_Repository respository;
	@Autowired
	private Customer_repository custRepository;
	@Autowired
	private Service_repository serviceRepository;
	@Autowired
	private Appointment_repository appointmentRepository;
	@Override
	public Workers addWorker(Workers worker) {
		respository.save(worker);
		return worker;
	}
	@Override
	public Customer isAddCustomerr(Customer customer) {
	
		return custRepository.save(customer);
	}
	@Override
	public Services isAddService(Services servi,int customerId,int workerId, int appointmentId) {
		Optional<Customer> custList=custRepository.findById(customerId);
		Customer cust;
		Workers work;
		Appointments appointmnet;
		if(custList.isEmpty()) {
			return null;
		}else {
			cust=custList.get();
		}
		
		Optional<Workers> workList= respository.findById(workerId);
		if (workList.isEmpty()) {
			return null;
		} else {
			work=workList.get();
		}
		Optional<Appointments> appoinList= appointmentRepository.findById(appointmentId);
		
		if (appoinList.isEmpty()) {
			return null;
		}else {
			appointmnet=appoinList.get();;
		}
		servi.setCustomer(cust);
		servi.setWorker(work);
		servi.setApointment(appointmnet);
		return serviceRepository.save(servi);
	}
	@Override
	public Appointments isAddAppointment(Appointments appointment) {
		
		return appointmentRepository.save(appointment);
	}
	
}
