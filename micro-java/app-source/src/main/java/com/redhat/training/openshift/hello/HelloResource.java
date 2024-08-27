package com.redhat.training.openshift.hello;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/api")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class HelloResource {

    @ConfigProperty(name = "HOSTNAME", defaultValue = "unknown")
    String hostname;
    @ConfigProperty(name = "APP_MSG")
    Optional<String> message;

    @GET
    @Path("/hello")
    public String hello() {
        String response = "";

      	if (!message.isPresent()) {
      	  response = "Hello world from host " + hostname + "\n";
      	} else {
      	  response = "Hello world from host [" + hostname + "].\n";
      	  response += "Message received = " + message.get() + "\n";
        }
        return response;
    }
    
    
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/env")
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