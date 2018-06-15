package com.revion777.services;

import com.revion777.models.EmployeeEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class MyResource {

    EmployeeEntity empEnt;
    EmployeeService empSer = new EmployeeService();

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String createNewEmployee(
            @FormParam("id") int id,
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("patronymic") String patronymic,
            @FormParam("position") String position) {

        empEnt = new EmployeeEntity(id, name, surname, patronymic, position);
        System.out.println("sout before sending data to db, post: " + name + ", " + surname + ", " + patronymic + ", " + position);
        empSer.save(empEnt);

        return "<h4><em>Сотрудник <em>" +id+", "+ surname + " " + name + " " + patronymic + " (" + position + ") добавлен в базу данных" + "</em></h4>";
    }

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String getEmployees(@QueryParam("id") int id) {
        empEnt = empSer.findEmployee(id);

        return "<h4><em>Сотрудник: <em>" + empEnt.getId()+ " " + empEnt.getSurname() + " " + empEnt.getName() + " " + empEnt.getPatronymic() + " (" + empEnt.getPosition() + ") находится в базе данных" + "</em></h4>";

    }
}