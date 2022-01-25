package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentImpl implements  DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        var depDB = departmentRepository.findById(id).get();

        if (Objects.nonNull(department.getName()) &&
            !"".equalsIgnoreCase(department.getName())){

            depDB.setName(department.getName());
        }

        if (Objects.nonNull(department.getCode()) &&
            !"".equalsIgnoreCase(department.getCode())){

            depDB.setCode(department.getCode());
        }

        if (Objects.nonNull(department.getAddress()) &&
            !"".equalsIgnoreCase(department.getAddress())){

            depDB.setAddress(department.getAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String department) {
        return departmentRepository.findByName(department);
    }


}
