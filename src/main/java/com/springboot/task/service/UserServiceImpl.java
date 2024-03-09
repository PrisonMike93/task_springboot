package com.springboot.task.service;

import com.springboot.task.dao.UserDao;
import com.springboot.task.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }



    @Transactional
    @Override
    public void delete(long id) {
        User user = userDao.findById(id).get();
        userDao.delete(user);
    }

    @Transactional
    @Override
    public void update(long id, User user) {
            User user1 = userDao.findById(id).get();
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setEmail(user.getEmail());
            add(user1);
    }



    
    @Override
    public User getUserById(long id) {
        return userDao.findById(id).get();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.findAll() ;
    }
}

