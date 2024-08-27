package com.redhat.training.openshift.hello;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class HelloResource {

	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String hello() {
		String hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
		String message = System.getenv().getOrDefault("APP_MSG", null);
		String response = "";
		String history = "";

    try{
      InputStream url = getClass().getResourceAsStream("/master.txt");
      BufferedReader reader = new BufferedReader(new InputStreamReader(url));
      String line = reader.readLine();
      while(line != null) {
    	  System.out.println(line);
    	  history = history + line +  "\n";    	  
    	  line = reader.readLine();
      }
    }catch(Exception e){
      e.printStackTrace();
      history = e.getMessage();
    }

		if (message == null)
			response = "Hello world from host " + hostname + "\n";
		else
			response = "Hello world from host [" + hostname + "]. Message received = " + message + "\n";

		return response + "\n" + history;
	}

	@SuppressWarnings("rawtypes")
	@GET
	@Path("/env")
	@Produces("text/plain")
	public String env() {
		StringBuilder response = new StringBuilder();
		Set getenv = System.getenv().entrySet();
		append(response,"System-Env",getenv);
		Set getProps = System.getProperties().entrySet();
		append(response,"System-Props",getProps);
		
		return response.toString();
	}

	@SuppressWarnings("rawtypes")
	private void append(StringBuilder response, String string, Set set) {
		response.append("-------------------------------------------------------------------------\n");
		response.append(string + "\n");
		response.append("-------------------------------------------------------------------------\n");
		Iterator<Entry> iterator = set.iterator();
		while(iterator.hasNext()) {
			Entry entry = iterator.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			response.append(key +"=" + value + "\n");
		}
	}


}
