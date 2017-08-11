package com.imprender.dropwizardsample.controller;

import com.imprender.dropwizardsample.model.Transaction;
import com.imprender.dropwizardsample.model.User;
import com.imprender.dropwizardsample.util.MustacheUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("/transactions")
@Produces(MediaType.TEXT_HTML)
public class TransactionsController {

	private List<Transaction> transactions;
	private List<User> users;

	public TransactionsController() {

		users = User.load();
		transactions = new ArrayList<>();

		transactions.add(new Transaction(users.get(0), users.get(1), 32));
		transactions.add(new Transaction(users.get(1), users.get(2), 23));
		transactions.add(new Transaction(users.get(2), users.get(3), 21));
	}



	@GET
	public String viewTransactions() throws IOException {

		Map<String, String> headerValues = new HashMap<>();
		headerValues.put("Title", "List Of Transactions");
		headerValues.put("Style", "GeneralStyle.css");

		return MustacheUtil.customizeTemplate(transactions, "templates/transactions.html", headerValues).toString();

	}

	@GET
	@Path("{id}")
	public String viewTransactions(@PathParam("id") int id) throws IOException {

		Map<String, String> headerValues = new HashMap<>();
		headerValues.put("Title", "Transaction information");
		headerValues.put("Style", "GeneralStyle.css");

		return MustacheUtil.customizeTemplate(transactions.get(id), "templates/transaction.html", headerValues).toString();
	}

	private String goToMenu() {
		String html = "<a href=\"http://localhost:8080/users\">Go to users</a>";
		html += "<br><a href=\"http://localhost:8080/transactions\">Go to transactions</a>";
		return html;
	}
}
