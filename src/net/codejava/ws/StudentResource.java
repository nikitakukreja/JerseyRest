package net.codejava.ws;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
public class StudentResource {
	
	private StudentDAO dao = StudentDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student>lis(){
		return dao.listAll();
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response add(Student student) throws URISyntaxException {
		int newstudentno = dao.add(student);
		URI uri = new URI("/JerseyRest/rest/students/" + newstudentno);
		
		return Response.created(uri).build();
	}
	
	@GET
	@Path("{no}")
	
	public Response get(@PathParam("no")int no) {
		Student student = dao.get(no);
		if(student != null) {
			return Response.ok(student, MediaType.APPLICATION_JSON).build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{no}")

	public Response update(@PathParam("no")int no,Student student) {
		 student.setNo(no);
		if(dao.update(student)) {
			return Response.ok().build();
		}
		else {
			return Response.notModified().build();
		}
	}
	
	@DELETE
	@Path("{no}")

	public Response delete(@PathParam("no")int no) {
		 
		if(dao.delete(no)) {
			return Response.ok().build();
		}
		else {
			return Response.notModified().build();
		}
	}
	
}
