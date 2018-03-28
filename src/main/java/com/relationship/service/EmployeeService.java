package com.relationship.service;

import com.relationship.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public List getAllAddress() {
        return employeeDao.getAllAddress();
    }

}
