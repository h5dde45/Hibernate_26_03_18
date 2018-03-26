package com.hbrnt.dao;

import com.hbrnt.models.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void saveContact(Contact contact){
        Session session = sessionFactory.getCurrentSession();
        session.save(contact);
    }

    public List getAllContacts(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Contact.class).list();
    }

    public List orderAscFirstName(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Contact.class).
                addOrder(Order.asc("firstName")).list();
    }
}
