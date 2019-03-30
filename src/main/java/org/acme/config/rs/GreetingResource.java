package org.acme.config.rs;

import org.acme.config.model.Computer;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Path("/greeting")
@Produces(MediaType.TEXT_PLAIN)
public class GreetingResource {


    @ConfigProperty(name = "greeting.message")
    private String message;

    @ConfigProperty(name = "greeting.suffix", defaultValue="!")
    private String suffix;

    @ConfigProperty(name = "greeting.name")
    private Optional<String> name;

    @ConfigProperty(name="myPets")
    private Set<String> myPetsSet;

    @ConfigProperty(name = "date.property")
    LocalDate date;

    @ConfigProperty(name="computer")
    private Computer computer;

    @ConfigProperty(name = "application.address", defaultValue = "10.0.0.1")
    private InetAddress inetAddress;

    @ConfigProperty(name = "application.url", defaultValue = "http://localhost")
    URL urlObject;

    @GET
    public String hello() {
        return message + " " + name.orElse("world") + suffix;
    }

    @GET
    @Path("pets")
    public Set<String> pets() {
        return myPetsSet;
    }

    @GET
    @Path("date")
    public LocalDate date() {
        return date;
    }

    @GET
    @Path("date")
    public Computer computer() {
        return computer;
    }

}