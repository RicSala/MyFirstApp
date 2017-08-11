package com.imprender.dropwizardsample.controller;


import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.imprender.dropwizardsample.model.User;
import com.imprender.dropwizardsample.util.MustacheUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
	public String viewUsers() throws IOException {

		Map<String, String> headerValues = new HashMap<>();
		headerValues.put("Title", "List of users");
		headerValues.put("Style", "GeneralStyle.css");

		return MustacheUtil.customizeTemplate(users, "templates/users.html", headerValues).toString();
	}

	@GET
	@Path("{id}")
	public String viewUsers(@PathParam("id") int id) throws IOException {

		Map<String, String> headerValues = new HashMap<>();
		headerValues.put("Title", "User information");
		headerValues.put("Style", "Styles.css");

		return MustacheUtil.customizeTemplate(users.get(id), "templates/profileCard.html", headerValues).toString();
	}


}
