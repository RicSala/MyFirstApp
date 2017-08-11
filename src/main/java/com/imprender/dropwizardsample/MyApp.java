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

/**
 * TODO: 1) REFACTORIZAR...ESTÁ HECHO UN ASCO
 * TODO: 2) HOJA DE ESTILOS ÚNICA
 * TODO: 3) PEGAR UN REPASO A CURSO HTML Y CSS Y DECIDIR UNA ÚNICA FORMA DE HACERLOS (MOBILE FIRST)
 * TODO: 4) LLEVARSE LA LIBRERÍA DE MUSTACHE A OTRO LADO
 * TODO: 5) APLICAR UNA INTERFACE A LA FORMA DE GUARDAR PARA PODER POSTERIORMENTE PASAR A BASE DE DATOS
 */


public class MyApp extends Application<MyAppConfig> {
//EXTIENDO LA CLASE APLICACIÓN PARA HEREDAR TODOS SUS MÉTODOS


	public static void main(String[] args) throws Exception {
		new MyApp().run(args);
	}


	//PARA QUÉ SIRVE ESTO??
	@Override
	public String getName() {
		return "my-app";
	}


	//¿? ES EL BOOTSTRAP DE HTML??
	@Override
	public void initialize(Bootstrap<MyAppConfig> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/files/"));
	}

	//
	@Override
	public void run(MyAppConfig myAppConfig, Environment environment) throws Exception {

		final UsersController usersController = new UsersController();
		environment.jersey().register(usersController);  //TODO: ESTÁ REGISTRANDO EL RECURSO (LA URL???)

		final TransactionsController transactions = new TransactionsController();
		environment.jersey().register(transactions);  //TODO: ESTÁ REGISTRANDO EL RECURSO (LA URL???)


	}

}
