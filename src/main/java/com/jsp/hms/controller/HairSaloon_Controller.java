package com.jsp.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.hms.entitty.Appointments;
import com.jsp.hms.entitty.Customer;
import com.jsp.hms.entitty.Services;
import com.jsp.hms.entitty.Workers;
import com.jsp.hms.service.Is_HairSaloon_Service;
import com.jsp.hms.util.ResponseStructure;
@Controller
@ResponseBody
public class HairSaloon_Controller {
	@Autowired
	private Is_HairSaloon_Service service;
	@RequestMapping(value = "/addworker",method =RequestMethod.POST)
	public ResponseEntity<ResponseStructure<Workers>> isAdd(@RequestBody Workers worker) {
				Workers worker1 = service.addWorker(worker);
				ResponseStructure<Workers> rs=new ResponseStructure<Workers>();
				rs.setStatusCode(HttpStatus.ACCEPTED.value());
				rs.setMessage("Data is inserted succesfully");
				rs.setData(worker1);
				
				return new ResponseEntity<ResponseStructure<Workers>>(rs,HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "/addCustomer",method =RequestMethod.POST)
	public ResponseEntity<ResponseStructure<Customer>> isAddCustomer(@RequestBody Customer customer) {
				Customer customer1 = service.isAddCustomerr(customer);
				ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
				rs.setStatusCode(HttpStatus.ACCEPTED.value());
				rs.setMessage("Data is inserted succesfully");
				rs.setData(customer1);
				return new ResponseEntity<ResponseStructure<Customer>>(rs,HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "/addService",method =RequestMethod.POST)
	public ResponseEntity<ResponseStructure<Services>> isAddService(@RequestBody Services servi,int customerId,int workerId, int appointmentId) {
				Services serv = service.isAddService(servi,customerId,workerId,appointmentId);
				ResponseStructure<Services> rs=new ResponseStructure<Services>();
				rs.setStatusCode(HttpStatus.ACCEPTED.value());
				rs.setMessage("Data is inserted succesfully");
				rs.setData(servi);
				return new ResponseEntity<ResponseStructure<Services>>(rs,HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "/addAppointment",method =RequestMethod.POST)
	public ResponseEntity<ResponseStructure<Appointments>> isAddAppointment(@RequestBody Appointments appointment) {
				Appointments appointments = service.isAddAppointment(appointment);
				ResponseStructure<Appointments> rs=new ResponseStructure<Appointments>();
				rs.setStatusCode(HttpStatus.ACCEPTED.value());
				rs.setMessage("Data is inserted succesfully");
				rs.setData(appointments);
				return new ResponseEntity<ResponseStructure<Appointments>>(rs,HttpStatus.ACCEPTED);
	}
}
