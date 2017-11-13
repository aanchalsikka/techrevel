package blog.techrevel.component.impl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

@Component(name = "Sample Component", property = { "testProperty=Hello" })
public class SampleComponentImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleComponentImpl.class);

	@Activate
	protected void activate(ComponentContext componentContext) {
		LOGGER.info("Registering: " + componentContext.getProperties().get("testProperty").toString());
	}
	
	@Deactivate
	protected void deactivate(ComponentContext componentContext) {
		LOGGER.info("Deregistering: " + componentContext.getProperties().get("testProperty").toString());
	}
}
