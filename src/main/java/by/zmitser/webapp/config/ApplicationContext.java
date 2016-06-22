package by.zmitser.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"by.zmitser.webapp.dao"})
@EnableTransactionManagement
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

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);

        return vendorAdapter;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory);
//        DatabasePopulatorUtils.execute(databasePopulator(), dataSource());
        return manager;

    }
//    public DatabasePopulator databasePopulator(){
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        databasePopulator.setContinueOnError(true);
//        databasePopulator.addScript(new ClassPathResource("db/insert.sql"));
//        return databasePopulator;
//
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean managerFactory = new LocalContainerEntityManagerFactoryBean();
/*
        <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"
        p:dataSource-ref="dataSource"
        p:packagesToScan="ru.javawebinar.**.model">
        <!--p:persistenceUnitName="persistenceUnit">-->
        <property name="jpaPropertyMap">
        <map>
        <entry key="#{T(org.hibernate.cfg.AvailableSettings).FORMAT_SQL}" value="${hibernate.format_sql}"/>
        <entry key="#{T(org.hibernate.cfg.AvailableSettings).USE_SQL_COMMENTS}" value="${hibernate.use_sql_comments}"/>
        <!--<entry key="#{T(org.hibernate.cfg.AvailableSettings).HBM2DDL_AUTO}" value="${hibernate.hbm2ddl.auto}"/>-->
        <entry key="#{T(org.hibernate.cfg.AvailableSettings).CACHE_REGION_FACTORY}" value="org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory"/>
        <entry key="#{T(org.hibernate.cfg.AvailableSettings).USE_SECOND_LEVEL_CACHE}" value="true"/>
        <entry key="#{T(org.hibernate.cfg.AvailableSettings).USE_QUERY_CACHE}" value="false"/> <!--default-->
        <entry key="#{T(org.hibernate.cache.ehcache.AbstractEhcacheRegionFactory).NET_SF_EHCACHE_CONFIGURATION_RESOURCE_NAME}" value="cache/ehcache.xml"/>
        <!--
                <entry key="javax.persistence.schema-generation.scripts.action" value="drop-and-create"/>
        <entry key="javax.persistence.schema-generation.scripts.create-target" value="${TOPJAVA_ROOT}/config/ddl/create.ddl"/>
        <entry key="javax.persistence.schema-generation.scripts.drop-target" value="${TOPJAVA_ROOT}/config/ddl/drop.ddl"/>
                -->
        </map>
        </property>
        <property name="jpaVendorAdapter">
        <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter"
        p:showSql="${jpa.showSql}">
        </bean>
        </property>
        </bean>
*/
        managerFactory.setDataSource(dataSource());
        managerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        managerFactory.setPackagesToScan("by.zmitser.webapp.domain");
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        managerFactory.setJpaProperties(jpaProperties);
        return managerFactory;
    }

}
