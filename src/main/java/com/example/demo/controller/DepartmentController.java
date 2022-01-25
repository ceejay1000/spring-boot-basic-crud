package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside saveDepartment of Department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id){
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return "Department deleted successfully";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String department){
        return departmentService.fetchDepartmentByName(department);
    }
}
