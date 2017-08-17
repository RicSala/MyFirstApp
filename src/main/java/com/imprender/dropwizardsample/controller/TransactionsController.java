package com.imprender.dropwizardsample.controller;

import com.imprender.dropwizardsample.model.Transaction;
import com.imprender.dropwizardsample.model.UserList;
import com.imprender.webapputils.MustacheUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Path("/transactions")
@Produces(MediaType.TEXT_HTML)
public class TransactionsController {

	private List<Transaction> transactions;
	private UserList users;

	public TransactionsController() {

		users = UserList.load();
		transactions = new ArrayList<>();

		transactions.add(new Transaction(users.get(0), users.get(1), 32));
		transactions.add(new Transaction(users.get(1), users.get(2), 23));
		transactions.add(new Transaction(users.get(2), users.get(3), 21));
	}



	@GET
	public String viewTransactions() {

		Map<String, String> headerMap = MustacheUtil.customizeHeader("List Of Transactions", "GeneralStyle.css");

		return MustacheUtil.customizeTemplate(transactions, headerMap, "templates/transactions.html").toString();

	}

	@GET
	@Path("{id}")
	public String viewTransactions(@PathParam("id") int id) {

		return MustacheUtil.customizeTemplate(transactions.get(id), MustacheUtil.customizeHeader("Transaction information", "GeneralStyle.css"), "templates/transaction.html").toString();
	}

}
