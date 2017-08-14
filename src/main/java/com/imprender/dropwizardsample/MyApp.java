package com.imprender.dropwizardsample;

import com.imprender.dropwizardsample.controller.TransactionsController;
import com.imprender.dropwizardsample.controller.UsersController;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * TO START SERVER, RUN WITH ARGS "server"
 */

/*
 * TODO: 3) PEGAR UN REPASO A CURSO HTML Y CSS Y DECIDIR UNA ÚNICA FORMA DE HACERLOS (MOBILE FIRST)
 * TODO: 5) APLICAR UNA INTERFACE A LA FORMA DE GUARDAR PARA PODER POSTERIORMENTE PASAR A BASE DE DATOS
 */


public class MyApp extends Application<MyAppConfig> {
//EXTIENDO LA CLASE APLICACIÓN PARA HEREDAR TODOS SUS MÉTODOS


	public static void main(String[] args) throws Exception {
		new MyApp().run(args);
	}


	@Override
	public String getName() {
		return "my-app";
	}


	@Override
	public void initialize(Bootstrap<MyAppConfig> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/assets/"));
	}

	//
	@Override
	public void run(MyAppConfig myAppConfig, Environment environment) throws Exception {

		final UsersController usersController = new UsersController();
		environment.jersey().register(usersController);

		final TransactionsController transactions = new TransactionsController();
		environment.jersey().register(transactions);


	}

}
