package com.imprender.dropwizardsample;

import com.imprender.dropwizardsample.resources.TransactionsResource;
import com.imprender.dropwizardsample.resources.UsersResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * TO START SERVER, RUN WITH ARGS "server"
 */


public class MyApp extends Application<MyAppConfig> {



	public static void main(String[] args) throws Exception {
		new MyApp().run(args);
	}


	//PARA QUÉ SIRVE ESTO??
	@Override
	public String getName() {
		return "my-app";
	}


	//¿?
	@Override
	public void initialize(Bootstrap<MyAppConfig> bootstrap) {
		//NOTING TO DO YET!
	}


	//
	@Override
	public void run(MyAppConfig myAppConfig, Environment environment) throws Exception {

		final TransactionsResource transactions = new TransactionsResource();
		environment.jersey().register(transactions);  //TODO: ESTÁ REGISTRANDO EL RECURSO (LA URL???)

		final UsersResource usersResource = new UsersResource();
		environment.jersey().register(usersResource);  //TODO: ESTÁ REGISTRANDO EL RECURSO (LA URL???)

	}

}
