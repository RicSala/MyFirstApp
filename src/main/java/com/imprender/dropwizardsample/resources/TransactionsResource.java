package com.imprender.dropwizardsample.resources;

import com.imprender.dropwizardsample.model.Transaction;
import com.imprender.dropwizardsample.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/transactions")
@Produces(MediaType.TEXT_HTML)
public class TransactionsResource {

	private List<Transaction> transactions;
	private List<User> users;

	public TransactionsResource() {
		users = new ArrayList<>();

		users.add(new User("Ricardo", "11/03/1986", 200));
		users.add(new User("Ferran", "11/03/1986", 200));
		users.add(new User("Laia", "11/03/1986", 200));
		users.add(new User("Xabi", "11/03/1986", 200));

		transactions = new ArrayList<>();

		transactions.add(new Transaction(users.get(1), users.get(2), 22));
		transactions.add(new Transaction(users.get(2), users.get(3), 22));
		transactions.add(new Transaction(users.get(3), users.get(4), 22));
	}

	@GET
	public String viewTransactions() {
		String html = "<h1>Recommended books</h1>";
		html += "<ul>";

		for (Transaction transaction : transactions) {

			html += "<li>" + transaction.getGiver() + " gives " +
					transaction.getAmount() + " bitcoins to " +
					transaction.getReceiver() + "<li>";
		}
		html += "</ul>";

		return html;
	}
}
