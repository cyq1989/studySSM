package com.yq.service;

import com.yq.dao.UserDao;
import com.yq.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUser(int id) {
        return userDao.getUser(id);
    }

//    public User getUser(int id, String name) {
//        return userDao.getUser(id, name);
//    }

    public void dropTable(String tableName) {
        userDao.dropTable(tableName);
    }

    public User selectUser(int id) {
        return userDao.selectUser(id);
    }

//    public User selectUser(int id, String name) {
//        return userDao.selectUser(id, name);
//    }
    @Transactional
    public void insertValue(User user) {
        userDao.insertValue(user);
//        int a = 1 / 0;
//        System.out.println(a);
    }

}
