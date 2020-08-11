package de.wps.dot.filmprogramm;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

import javax.naming.NamingException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class FilmprogrammClientProxy {
	private static Gson gson = new Gson();

	public List<Vorführung> getVorführungen() throws UnirestException, NamingException {
		List<Vorführung> vorführungen = null;

		URI uri = URI.create("http://kino-ticket-service.kino/vorführungen");

		HttpResponse<String> response = Unirest.get(uri.toString()).asString();
		System.out.println("Filmprogramm-Service: " + response.getStatus());
		System.out.println("Filmprogramm-Service-Body: " + response.getBody());
		Type vorführungsListenTyp = new TypeToken<List<Vorführung>>() {
		}.getType();
		vorführungen = gson.fromJson(response.getBody(), vorführungsListenTyp);

		return vorführungen;
	}
}
