package com.myorg.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.myorg", excludeFilters = {@ComponentScan.Filter(value = Controller.class)})
public class RootConfiguration {

    @Value("${hibernate.dialect}")
    String hibernate_dialect;
    @Value("${hibernate.show_sql}")
    String hibernate_show_sql;

    @Resource(name = "dataSource")
    private ComboPooledDataSource dataSource;

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        String[] packagesToScan = new String[]{"com.myorg.model"};
        sessionFactoryBean.setPackagesToScan(packagesToScan);
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", hibernate_dialect);
        hibernateProperties.setProperty("hibernate.show_sql", hibernate_show_sql);
        hibernateProperties.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        return sessionFactoryBean;
    }

    @Bean
    public static PropertyPlaceholderConfigurer loadConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        ClassPathResource resource = new ClassPathResource("jdbc.properties");
        configurer.setLocation(resource);
        return configurer;
    }
}
