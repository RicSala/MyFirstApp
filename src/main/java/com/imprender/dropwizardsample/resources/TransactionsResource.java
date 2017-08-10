package com.imprender.dropwizardsample.resources;

import com.imprender.dropwizardsample.model.Transaction;
import com.imprender.dropwizardsample.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

		users = User.load();
		transactions = new ArrayList<>();

		transactions.add(new Transaction(users.get(0), users.get(1), 32));
		transactions.add(new Transaction(users.get(1), users.get(2), 23));
		transactions.add(new Transaction(users.get(2), users.get(3), 21));
	}



	@GET
	public String viewTransactions() {
		String html = "<h1>List of transactions</h1>";
		html += "<ul>";

		for (Transaction transaction : transactions) {

			html += "<li>" + transaction.getGiver().getNameLink() + " gives " +
					transaction.getAmountLink() + " bitcoins to " +
					transaction.getReceiver().getNameLink() + "</li>";
		}
		html += "</ul>";
		html += goToMenu();

		return html;
	}

	@GET
	@Path("{id}")
	public String viewTransactions(@PathParam("id") int id) {

		Transaction transaction = transactions.get(id);

		String html = "<h1>" + transaction.getGiver() + "  -----" + transaction.getAmount() + "----->  " + transaction.getReceiver() + "</h1>";
		html += "<ul>Transaction information:" +
				"<li><strong>Giver</strong>: " + transaction.getGiver() + "</li>" +
				"<li><strong>Receiver</strong>: " + transaction.getReceiver() + "</li>" +
				"<li><strong>Date</strong>: " + transaction.getDate() + "</li>" +
				"<li><strong>Amount</strong>: " + transaction.getAmount() + "</li>" + "</ul>" +
				"<br><br><br>" +
				"<p>This transaction is " +
				(transaction.isVerified() ? "" : "not ") +       //POR USAR ALGUNA VEZ ESTO....
				"verified<br>";
		html += goToMenu();
		return html;
	}

	private String goToMenu() {
		String html = "<a href=\"http://localhost:8080/users\">Go to users</a>";
		html += "<br><a href=\"http://localhost:8080/transactions\">Go to transactions</a>";
		return html;
	}
}
