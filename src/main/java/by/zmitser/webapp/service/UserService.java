package by.zmitser.webapp.service;

import by.zmitser.webapp.domain.User;

public interface UserService {

    User findById(long id);
    User findWithBlogPostsByUsername(String username);
}
