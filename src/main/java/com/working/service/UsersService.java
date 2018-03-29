package com.working.service;

import com.working.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersDao usersDao;

    @Transactional
    public List getAllUsers(){
        return usersDao.getAllUsers();
    }
}
