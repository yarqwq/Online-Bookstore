package com.web.bookshop.service;
import java.util.List;
import com.web.bookshop.dao.UserDao;
import com.web.bookshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User findById(String id) {
        return userDao.findById(id);
    }
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    public List<User> findAll() {
        return userDao.findAll();
    }
    public boolean createUser(User user) {
        return userDao.createUser(user) > 0;
    }
    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0;
    }
    public boolean deleteUser(String id) {
        return userDao.deleteUser(id) > 0;
    }
}