package com.mysample.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	
	StudentRepository repo = new StudentRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Student> getAllStudents() {
		System.out.println("Calling getAllStudents()");
		return repo.getStudents();
	}
	
	@GET
	@Path("student/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student getSpecificStudent(@PathParam("id") int id) {
		System.out.println("Calling getSpecificStudent()");
		return repo.getStudent(id);
	}
	
	@POST
	@Path("student")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student createStudent(Student stud) {
		System.out.println(stud);
		repo.createStudent(stud);
		return stud;
	}
}
