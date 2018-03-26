package com.hbrnt.service;

import com.hbrnt.dao.ContactDao;
import com.hbrnt.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDao contactDao;

    @Transactional
    public void saveContact(Contact contact){
        contactDao.saveContact(contact);
    }

    @Transactional
    public List getAllContacts(){
        return  contactDao.getAllContacts();
    }

    @Transactional
    public List orderAscFirstName(){
        return  contactDao.orderAscFirstName();
    }
}
