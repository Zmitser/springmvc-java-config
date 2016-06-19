package by.zmitser.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationContext {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(environment.getProperty("jdbc.driverClass"));
        source.setUrl(environment.getProperty("jdbc.url"));
        source.setUsername(environment.getProperty("jdbc.username"));
        source.setPassword(environment.getProperty("jdbc.password"));
        return source;
    }

}
