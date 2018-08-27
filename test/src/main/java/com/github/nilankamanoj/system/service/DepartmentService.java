package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Department;
import com.github.nilankamanoj.system.repository.DepartmentRepository;
import java.util.List;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		List<Department> departments = departmentRepository.findAll();
		return departments;
	}

	public Department findOne(Integer id) {
		Department department = departmentRepository.findOne(id);
		return department;
	}

	public Department save(Department department) {
		departmentRepository.save(department);
		Department newDepartment = departmentRepository.findOne(department.getId());
		return newDepartment;
	}

}