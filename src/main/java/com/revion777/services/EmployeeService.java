package com.revion777.services;

import com.revion777.dao.EmployeeDao;
import com.revion777.models.EmployeeEntity;
import java.util.List;

public class EmployeeService {

    private EmployeeDao empsDao = new EmployeeDao();

    public EmployeeEntity findEmployee(int id) {
        return empsDao.findById(id);
    }

    public void save(EmployeeEntity emp) {
        empsDao.save(emp);
    }

    public void delete(EmployeeEntity emp) {
        empsDao.delete(emp);
    }

    public void update(EmployeeEntity emp) {
       empsDao.update(emp);
    }

    public List<EmployeeEntity> findAllEmployees() {
        return empsDao.findAll();
    }
}
