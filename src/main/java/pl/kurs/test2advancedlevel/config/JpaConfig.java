package pl.kurs.test2advancedlevel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class JpaConfig {

    @Autowired
    private Environment env;

    @Profile("!dev & !prod")
    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF_generic(JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceUnitName("springPersistenceUnit");
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", env.getProperty("jdbc.url"));
        properties.put("javax.persistence.jdbc.user", env.getProperty("jdbc.user"));
        properties.put("javax.persistence.jdbc.password", env.getProperty("jdbc.pass"));
        properties.put("javax.persistence.jdbc.driver", env.getProperty("jdbc.driverClassName"));
        properties.put("javax.persistence.schema-generation.database.action", env.getProperty("hibernate.database.action"));
        emf.setJpaPropertyMap(properties);
        emf.setPackagesToScan("pl.kurs.test2advancedlevel.model");
        emf.setJpaVendorAdapter(adapter);
        return emf;
    }

    @Profile("prod")
    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceUnitName("springPersistenceUnit");
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", env.getProperty("jdbc.url"));
        properties.put("javax.persistence.jdbc.user", env.getProperty("jdbc.user"));
        properties.put("javax.persistence.jdbc.password", env.getProperty("jdbc.pass"));
        properties.put("javax.persistence.jdbc.driver", env.getProperty("jdbc.driverClassName"));
        properties.put("javax.persistence.schema-generation.database.action", env.getProperty("hibernate.database.action"));
        emf.setJpaPropertyMap(properties);
        emf.setPackagesToScan("pl.kurs.test2advancedlevel.model");
        emf.setJpaVendorAdapter(adapter);
        return emf;
    }

    @Profile("dev")
    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF_dev(JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceUnitName("springPersistenceUnit");
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", env.getProperty("dev.jdbc.url"));
        properties.put("javax.persistence.jdbc.user", env.getProperty("dev.jdbc.user"));
        properties.put("javax.persistence.jdbc.password", env.getProperty("dev.jdbc.pass"));
        properties.put("javax.persistence.jdbc.driver", env.getProperty("dev.jdbc.driverClassName"));
        properties.put("javax.persistence.schema-generation.database.action", env.getProperty("dev.hibernate.database.action"));
        emf.setJpaPropertyMap(properties);
        emf.setPackagesToScan("pl.kurs.test2advancedlevel.model");
        emf.setJpaVendorAdapter(adapter);
        return emf;
    }

    @Profile("!dev & !prod")
    @Bean
    public JpaVendorAdapter createJpaVendorAdapter_generic() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.valueOf(env.getProperty("db.type")));
        adapter.setShowSql(true);
        return adapter;
    }

    @Profile({"prod"})
    @Bean
    public JpaVendorAdapter createJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.valueOf(env.getProperty("db.type")));
        adapter.setShowSql(true);
        return adapter;
    }



    @Profile("dev")
    @Bean
    public JpaVendorAdapter createJpaVendorAdapter_dev() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.valueOf(env.getProperty("dev.db.type")));
        adapter.setShowSql(true);
        return adapter;
    }


}
