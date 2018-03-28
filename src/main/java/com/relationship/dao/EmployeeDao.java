package com.relationship.dao;

import com.relationship.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {
    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactoryRelationship")
    private SessionFactory sessionFactory;

    public List getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Employee.class).list();
    }

}
