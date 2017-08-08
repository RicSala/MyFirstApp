package com.imprender.dropwizardsample.resources;

import com.imprender.dropwizardsample.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/users")
@Produces(MediaType.TEXT_HTML)

public class UsersResource {

	private List<User> users = new ArrayList<>();


	public UsersResource() {
		users = new ArrayList<>();


		users.add(new User("Ricardo", "11/03/1986", 200));
		users.add(new User("Ferran", "11/03/1986", 200));
		users.add(new User("Laia", "11/03/1986", 200));
		users.add(new User("Xabi", "11/03/1986", 200));
	}

	@GET
	@Path("{id}")
	public String viewUsers(@PathParam("id") int id) {
		User user = users.get(id);

		String html = "<h1>Nombre: " + user.getName() + "</h1>";
		html += "<p>Fecha nacimiento: " + user.getDateOfBirth() + "</p>";
		html += "<p>Fondos en cuenta: " + user.getFunds() + "</p>";

		return html;

	}


}
