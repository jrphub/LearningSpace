package com.java8.Gstreams;

import java.util.List;
import java.util.Objects;

public class EmployeeRepository {
    private final List<Employee> empList;
    
    public EmployeeRepository(List<Employee> empList) {
        this.empList = empList;
    
    }
    public Employee findById(Integer id) {
        for (Employee emp : empList) {
            if (Objects.equals(emp.getId(), id)) { //emp.getId() == id
                return emp;
            }
        }
        
        return null;
    }
}