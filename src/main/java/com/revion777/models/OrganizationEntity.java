package com.revion777.models;

import javax.persistence.*;

@Entity
@Table(name = "organization", schema = "ecm_db")
public class OrganizationEntity {
    private int id;
    private String name;
    private String actAdress;
    private String legAdress;
    private Integer empId;

    private EmployeeEntity employeeByEmpId;

    public OrganizationEntity() {
    }

    public OrganizationEntity(String name, String actAdress, String legAdress) {
        this.name = name;
        this.actAdress = actAdress;
        this.legAdress = legAdress;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "act_adress", nullable = false, length = 255)
    public String getActAdress() {
        return actAdress;
    }

    public void setActAdress(String actAdress) {
        this.actAdress = actAdress;
    }

    @Basic
    @Column(name = "leg_adress", nullable = false, length = 255)
    public String getLegAdress() {
        return legAdress;
    }

    public void setLegAdress(String legAdress) {
        this.legAdress = legAdress;
    }

    @Basic
    @Column(name = "emp_id", nullable = true)
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationEntity that = (OrganizationEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (actAdress != null ? !actAdress.equals(that.actAdress) : that.actAdress != null) return false;
        if (legAdress != null ? !legAdress.equals(that.legAdress) : that.legAdress != null) return false;
        if (empId != null ? !empId.equals(that.empId) : that.empId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (actAdress != null ? actAdress.hashCode() : 0);
        result = 31 * result + (legAdress != null ? legAdress.hashCode() : 0);
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    public EmployeeEntity getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(EmployeeEntity employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }
}
