package by.zmitser.webapp.dao;

import by.zmitser.webapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Long>{

    User findUserByUsername(String username);
}
