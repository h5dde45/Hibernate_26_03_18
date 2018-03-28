package com.onetoone.service;

import com.onetoone.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public List getAllPassports() {
        return userDao.getAllPassports();
    }
}
