package com.imprender.dropwizardsample.util;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.imprender.dropwizardsample.model.User;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class MustacheUtil {

	public static StringWriter customizeTemplate(Object object, String file) throws IOException {
		MustacheFactory mustache = new DefaultMustacheFactory();
		Mustache template = mustache.compile(file); //LEE EL ARCHIVO HTML Y SE LO GUARDA SIN HACER NADA AÚN, SE LO PREPARAA
		StringWriter writer = new StringWriter(); //CREA UN NUEVO "ESCRITOR"
		template.execute(writer, object).flush();      //TRATA TEMPLATE CON EL MAPA DE VALORES
		return writer;
	}

	public static StringWriter customizeTemplate(Object values, String file, Map headerValues) throws IOException {
		Map<String, Object> valuesMap = new HashMap<>();
		valuesMap.put("headerValues", headerValues);
		valuesMap.put("Values", values);

		return customizeTemplate(valuesMap, file);
	}
}
