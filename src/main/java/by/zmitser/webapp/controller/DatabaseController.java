package by.zmitser.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Controller
public class DatabaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseController.class);

    @Autowired
    private DataSource dataSource;


    @RequestMapping(value = "/display-users")
    public void displayUsers() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<Map<String, Object>> users = template.queryForList("SELECT * FROM USER");
        for (Map<String, Object> user : users) {
            LOGGER.debug("username: "  + user.get("username")) ;
        }
    }
}
