package io.dropwizard.resources;

import io.dropwizard.api.Saying;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.*;
import io.dropwizard.core.template;
import io.dropwizard.jersey.params.*;
import io.dropwizard.jersey.caching.CacheControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.TimeUnit;
import java.util.Optional;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class testResources {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	
	public testResources (String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed(name = "get-requests-timed")
	@Metered(name = "get-requests-metered")
	@CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
	public Saying sayHello(@QueryParam("name") Optional<String> name) {
		final String value = String.format(template, name.orElse(defaultName));
		return new Saying(counter.incrementAndGet(), value);
	}
	
	@POST
	public void recieveHello(Saying saying) {
		LOGGER.info("Recieved a saying {}", saying);
	}
	
	@GET
	@Path("/date")
	@Produces(MediaType.TEXT_PLAIN)
	public String recieveDate(@QueryParam("date") Optional<DateTimeParam> dateTimeParam) {
		if (dateTimeParam.isPresent()) {
			final DateTimeParam actualDateTimeParam = dateTimeParam.get();
			LOGGER.info("Recieved a date: {}", actualDateTimeParam);
			return actualDateTimeParam.get().toString();
		}
		else {
			LOGGER.warn("Date not recieved");
			return null;
		}
	}
	
	
}
