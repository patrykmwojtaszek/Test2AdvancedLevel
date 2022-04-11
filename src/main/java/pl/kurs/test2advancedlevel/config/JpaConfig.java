package pl.kurs.test2advancedlevel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaConfig {

//    @Profile("prod")
//    @Bean
//    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter) {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setPersistenceUnitName("springPersistenceUnit");
//        Map<String, String> properties = new HashMap<>();
//        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/equation_event?useSSL=false&serverTimezone=UTC");
//        properties.put("javax.persistence.jdbc.user", "root");
//        properties.put("javax.persistence.jdbc.password", "root");
//        properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
//        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
////        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
//        emf.setJpaPropertyMap(properties);
//        emf.setPackagesToScan("pl.kurs.test2advancedlevel.model");
//        emf.setJpaVendorAdapter(adapter);
//        return emf;
//    }

    //@Profile("dev")
    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF_dev(JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceUnitName("springPersistenceUnit");
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", "jdbc:h2:mem:testdb");
        properties.put("javax.persistence.jdbc.user", "sa");
        properties.put("javax.persistence.jdbc.password", "password");
        properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
//        properties.put("javax.persistence.schema-generation.database.action", "create");
        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        emf.setJpaPropertyMap(properties);
        emf.setPackagesToScan("pl.kurs.test2advancedlevel.model");
        emf.setJpaVendorAdapter(adapter);
        return emf;
    }

//    @Profile("prod")
//    @Bean
//    public JpaVendorAdapter createJpaVendorAdapter() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setDatabase(Database.MYSQL);
//        adapter.setShowSql(true);
//        return adapter;
//    }


    //@Profile("dev")
    @Bean
    public JpaVendorAdapter createJpaVendorAdapter_dev() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(true);
        return adapter;
    }


}
