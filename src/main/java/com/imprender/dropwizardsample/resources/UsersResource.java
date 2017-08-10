package com.imprender.dropwizardsample.resources;

import com.imprender.dropwizardsample.model.User;
import com.imprender.dropwizardsample.resources.profileCard.HtmlUtility;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("/users")
@Produces(MediaType.TEXT_HTML)

public class UsersResource {

	private List<User> users = new ArrayList<>();


	public UsersResource() {
		users = new ArrayList<>();


		users.add(new User("Ricardo", "11/03/1986", 200, "Java delevoper"));
		users.add(new User("Ferran", "11/04/1986", 180, "Ruby delevoper"));
		users.add(new User("Laia", "11/05/1986", 202, "JS delevoper"));
		users.add(new User("Xabi", "11/06/1986", 178, "Python delevoper"));

		User.save(users);
	}


	@GET
	public String viewUsers() {
		String html =   "<h1>Lista de usuarios activos</h1>" +
						"<ul>";
		for (User user : users) {
			html += "<li>" + user.getNameLink() + "</li>";
		}
		html += "</ul>";

		html += goToMenu();

		return html;
	}

	@GET
	@Path("{id}")
	public String viewUsers(@PathParam("id") int id) throws IOException {

		User user = users.get(id);


		/*String html = HtmlUtility.readFile("src\\main\\java\\com\\imprender\\dropwizardsample\\resources\\profileCard\\profileCard.html", Charset.defaultCharset());
		Map<String, String> keysAndValues = new HashMap<>();
		keysAndValues.put("Name", user.getName());
		keysAndValues.put("Job", user.getJob());
		keysAndValues.put("FabPhrase", String.valueOf(user.getFunds()));


		HtmlUtility.substituteKeysPerValues(html, keysAndValues);
		*/


		String html = "<h1>Nombre: " + user.getName() + "</h1>";
		html += "<p><strong>Fecha nacimiento</strong>: " + user.getDateOfBirth() + "</p>";
		html += "<p><strong>Trabajo</strong>: " + user.getJob() + "</p>";
		html += "<p><strong>Fondos en cuenta</strong>: " + user.getFunds() + "</p>";

		html += goToMenu();




		return html;

	}

	private String goToMenu() {
		String html = "<a href=\"http://localhost:8080/users\">Go to users</a>";
		html += "<br><a href=\"http://localhost:8080/transactions\">Go to transactions</a>";
		return html;
	}


}
