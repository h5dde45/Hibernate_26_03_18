package com.onetoone.dao;

import com.onetoone.models.Passport;
import com.onetoone.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    @Qualifier(value = "hibernate4AnnotatedSessionFactoryRelationship")
    private SessionFactory sessionFactory;

    public List getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(User.class).list();
    }

    public List getAllPassports(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Passport.class).list();
    }
}
