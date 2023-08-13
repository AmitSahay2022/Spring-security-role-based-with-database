package com.sahay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahay.entity.Employee;
import com.sahay.exception.ResourceNotFoundException;
import com.sahay.repository.EmployeeRepository;
import com.sahay.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee, long id) {
		// TODO Auto-generated method stub
		Employee emp=employeeRepository.findById(id)
		                  .orElseThrow(
		                		  ()->new ResourceNotFoundException(
		                				  "Employee not found with id: "+id));
		emp.setEmailAddress(employee.getEmailAddress());
		emp.setMobileNumber(employee.getMobileNumber());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		return employeeRepository.save(emp);
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id)
                .orElseThrow(
              		  ()->new ResourceNotFoundException(
              				  "Employee not found with id: "+id));
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public String deleteById(long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(
						()->new ResourceNotFoundException("Employee not found with id: "+id));
		employeeRepository.delete(employee);
		return "Employee Deleted Successfully";
	}

}
