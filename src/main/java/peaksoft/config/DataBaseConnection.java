package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.*;

import java.util.Properties;

public class DataBaseConnection {
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/exam");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");

        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Programmer.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Country.class);
        configuration.addAnnotatedClass(Project.class);
        return configuration.buildSessionFactory();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        final SessionFactory sessionFactory = getSessionFactory();
        return sessionFactory.unwrap(EntityManagerFactory.class);
    }
}
