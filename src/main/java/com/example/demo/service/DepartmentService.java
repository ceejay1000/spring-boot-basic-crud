package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.exceptions.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String department);
}
