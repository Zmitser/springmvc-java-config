package by.zmitser.webapp.service.impl;

import by.zmitser.webapp.dao.UserDAO;
import by.zmitser.webapp.domain.User;
import by.zmitser.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findById(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public User findWithBlogPostsByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }
}
