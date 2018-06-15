package com.revion777.dao;

import com.revion777.models.EmployeeEntity;
import com.revion777.models.OrganizationEntity;
import com.revion777.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class OrganizationDao implements DaoFactory{

    @Override
    public OrganizationEntity findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OrganizationEntity.class, id);
    }

    @Override
    public void save(Object object){
        OrganizationEntity orgEnt = (OrganizationEntity) object;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(orgEnt);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Object object) {
        OrganizationEntity orgEnt = (OrganizationEntity) object;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(orgEnt);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Object object){
        OrganizationEntity orgEnt = (OrganizationEntity) object;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(orgEnt);
        tx1.commit();
        session.close();
    }

/*    @Override
    public EmployeeEntity findObjectById(int id) throws SQLException {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeeEntity.class, id);
    }*/

    @Override
    public List<OrganizationEntity> findAll(){
        List<OrganizationEntity> orgsEnt = (List<OrganizationEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From OrganizationEntity").list();
        return orgsEnt;
    }
}