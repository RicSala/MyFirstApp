package com.imprender.dropwizardsample.util;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class MustacheUtil {

	public static StringWriter customizeTemplate(Object object, String file) {
		MustacheFactory mustache = new DefaultMustacheFactory(); //CREA "FACTORÍA" (OBJECTO QUE HARÁ EL TRABAJO)
		Mustache template = mustache.compile(file); //LEE EL ARCHIVO HTML Y SE LO GUARDA SIN HACER NADA AÚN, SE LO PREPARAA
		StringWriter writer = new StringWriter(); //CREA UN NUEVO "ESCRITOR"

		try {
			template.execute(writer, object).flush();      //TRATA TEMPLATE CON EL MAPA DE VALORES
			return writer;
		} catch (IOException e) {
			throw new RuntimeException("Error while writing template result", e);
		}
	}


	public static StringWriter customizeTemplate(Object values, Map headerValues, String file) {
		Map<String, Object> valuesMap = new HashMap<>();
		valuesMap.put("headerValues", headerValues);
		valuesMap.put("Values", values);

		return customizeTemplate(valuesMap, file);
	}

	public static Map<String, String> customizeHeader(String title, String styleSheet) {
		Map<String, String> headerValues = new HashMap<>();
		headerValues.put("Title", title);
		headerValues.put("Style", styleSheet);
		return headerValues;
	}
}
