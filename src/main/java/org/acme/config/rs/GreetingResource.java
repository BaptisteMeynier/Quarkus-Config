package org.acme.config.rs;

import io.smallrye.config.SmallRyeConfig;
import io.smallrye.config.SmallRyeConfigBuilder;
import io.smallrye.config.SmallRyeConfigProviderResolver;
import org.acme.config.model.Computer;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.config.spi.ConfigBuilder;

import javax.inject.Inject;
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

    @ConfigProperty(name = "greeting.static.message")
    String STATIC_MESSAGE;

    @ConfigProperty(name = "greeting.message")
    String message;

    @ConfigProperty(name = "greeting.suffix", defaultValue="!")
    String suffix;

    @ConfigProperty(name = "greeting.name")
    Optional<String> name;

    @ConfigProperty(name="myPets")
    Set<String> myPetsSet;
/*
    @ConfigProperty(name = "date.property")
    LocalDate date;
*/
@Inject
    @ConfigProperty(name="computer")
    Computer computer;
/*
    @ConfigProperty(name = "application.address", defaultValue = "10.0.0.1")
    private InetAddress inetAddress;

    @ConfigProperty(name = "application.url", defaultValue = "http://localhost")
    URL urlObject;
*/
    @GET
    public String hello() {
        return message + " " + name.orElse("world") + suffix;
    }

    @GET
    @Path("pets")
    public Set<String> pets() {
        return myPetsSet;
    }

  /*  @GET
    @Path("date")
    public LocalDate date() {
        return date;
    }
*/
    @GET
    @Path("date")
    public Computer computer() {
        return computer;
    }

    @GET
    @Path("static")
    public String staticConfig() {
        return STATIC_MESSAGE;
    }

   /* public void init(){
    SmallRyeConfigBuilder builder = new SmallRyeConfigBuilder();
    Config build = builder.addDefaultSources().build();
    final SmallRyeConfig src = (SmallRyeConfig) builder.addDefaultSources()
            .addDiscoveredSources().addDiscoveredConverters().build();
    SmallRyeConfigProviderResolver.instance().registerConfig(src, Thread.currentThread().getContextClassLoader());

}*/


}