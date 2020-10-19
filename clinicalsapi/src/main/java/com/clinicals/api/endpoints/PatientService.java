package com.clinicals.api.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinicals.api.model.Patient;
import com.clinicals.api.repos.PatientRepo;

@Consumes("application/json")
@Produces("application/json")
@Path("/api")
public class PatientService {

	@Autowired
	PatientRepo repo;
	
	@Path("/patients")
	@GET
	public List<Patient> getPatients()
	{
		return repo.findAll();
		
	}
	
	@Path("/patients/{id}")
	@GET
	public Patient getPatient(@PathParam("id") int id)
	{
		
		return repo.findById(id).get();
	}
	
	@Path("/patient")
	@POST
	public Patient createPatient(Patient patient)
	{
		return repo.save(patient);
	}
	
	@Path("/patient/{id}")
	@DELETE
	public Response deletePatient(@PathParam("id") int id)
	{
		Patient entity = repo.findById(id).get();
		System.out.println(entity.toString());
		repo.delete(entity);
		
		return Response.ok().build();
	}
	
	
	@Path("/patient")
	@PUT
	public void updatePatient(Patient patient)
	{
		
	}
	
	//TODO Implement ClinicalApi
}
