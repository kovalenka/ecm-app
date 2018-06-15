package com.revion777.dao;

import com.revion777.models.EmployeeEntity;
import com.revion777.models.OrganizationEntity;
import com.revion777.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDao implements DaoFactory {

    @Override
    public EmployeeEntity findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeeEntity.class, id);
    }

    @Override
    public void save(Object object){
        EmployeeEntity empEnt = (EmployeeEntity) object;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(empEnt);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Object object){
        EmployeeEntity empEnt = (EmployeeEntity) object;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(empEnt);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Object object){
        EmployeeEntity empEnt = (EmployeeEntity) object;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(empEnt);
        tx1.commit();
        session.close();
    }

    @Override
    public List<EmployeeEntity> findAll(){
        List<EmployeeEntity> empsEnt = (List<EmployeeEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EmployeeEntity").list();
        return empsEnt;
    }
}
