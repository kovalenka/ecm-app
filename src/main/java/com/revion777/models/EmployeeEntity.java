package com.revion777.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "employee", schema = "ecm_db")
public class EmployeeEntity {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private Collection<OrganizationEntity> organizationsById;

    public EmployeeEntity() {
    }

    public EmployeeEntity(int id, String name, String surname, String patronymic, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        organizationsById = new ArrayList<>();
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
    @Column(name = "Name", nullable = true, length = 255)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Surname", nullable = true, length = 255)
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "Patronymic", nullable = true, length = 255)
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "Position", nullable = true, length = 255)
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public Collection<OrganizationEntity> getOrganizationsById() {
        return organizationsById;
    }

    public void setOrganizationsById(Collection<OrganizationEntity> organizationsById) {
        this.organizationsById = organizationsById;
    }
}
