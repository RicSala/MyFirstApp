package com.imprender.dropwizardsample.controller;


import com.imprender.dropwizardsample.model.User;
import com.imprender.webapputils.MustacheUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Path("/users")
@Produces(MediaType.TEXT_HTML)

public class UsersController {

	private List<User> users = new ArrayList<>();


	public UsersController() {
		users = new ArrayList<>();


		users.add(new User("Ricardo", "11/03/1986", 200, "Java delevoper", "https://ca.slack-edge.com/T31TKJJCA-U5DCZ153R-aa43d591b8c9-512"));
		users.add(new User("Ferran", "11/04/1986", 180, "Ruby delevoper", "https://ca.slack-edge.com/T31TKJJCA-U31U6GR4J-4f1fda04a98f-512"));
		users.add(new User("Laia", "11/05/1986", 202, "JS delevoper", "https://ca.slack-edge.com/T31TKJJCA-U5SDPVCG2-d262d8f1e04b-512"));
		users.add(new User("Javi", "11/06/1986", 178, "Python delevoper", "https://ca.slack-edge.com/T31TKJJCA-U5UACDBSQ-e25a2d870c57-512"));

		User.save(users);
	}


	@GET
	public String viewUsers() {

		Map<String, String> customizedHeader = MustacheUtil.customizeHeader("List of users", "GeneralStyle.css");
		return MustacheUtil.customizeTemplate(users, customizedHeader, "templates/users.html").toString();
	}

	@GET
	@Path("{id}")
	public String viewUsers(@PathParam("id") int id) {

		Map<String, String> customizedHeader = MustacheUtil.customizeHeader("User information", "GeneralStyle.css");

		return MustacheUtil.customizeTemplate(users.get(id), customizedHeader, "templates/profileCard.html").toString();
	}


}
