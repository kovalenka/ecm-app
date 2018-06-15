package com.revion777.utils;

import com.revion777.models.EmployeeEntity;
import com.revion777.models.OrganizationEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class HibernateSessionFactoryUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(EmployeeEntity.class);
            configuration.addAnnotatedClass(OrganizationEntity.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            ourSessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return ourSessionFactory;
    }
}