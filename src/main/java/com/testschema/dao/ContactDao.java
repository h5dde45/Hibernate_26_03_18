package com.testschema.dao;

import com.testschema.models.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDao {

    @Autowired
    @Qualifier("hibernate4AnnotatedSessionFactoryTestSchema")
    private SessionFactory sessionFactory;

    public void saveContact(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.save(contact);
    }

    public List getAllContacts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Contact.class).list();
    }

    public List orderAscFirstName() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Contact.class).
                addOrder(Order.asc("firstName")).list();
    }

    public List orderDescLastName() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Contact.class).
                addOrder(Order.desc("lastName")).list();
    }

    public List gtVersion() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Contact.class).
                add(Restrictions.gt("version", 5)).list();
    }
}
