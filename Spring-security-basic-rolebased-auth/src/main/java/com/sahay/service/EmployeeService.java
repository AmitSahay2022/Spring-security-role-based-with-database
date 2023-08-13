package com.sahay.service;

import java.util.List;

import com.sahay.entity.Employee;

public interface EmployeeService {
	public Employee save(Employee employee);

	public Employee update(Employee employee, long id);

	public Employee getById(long id);

	public List<Employee> getAll();

	public String deleteById(long id);
}
