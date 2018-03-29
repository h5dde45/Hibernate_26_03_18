package com.working.dao;

import com.working.models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDao {

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactoryWorking")
    private SessionFactory sessionFactory;

    public List getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Users.class)
                .add(Restrictions.like("email","e", MatchMode.START))
                .add(Restrictions.between("age",10,40))
                .addOrder(Order.desc("id"))
                .list();
    }

}
