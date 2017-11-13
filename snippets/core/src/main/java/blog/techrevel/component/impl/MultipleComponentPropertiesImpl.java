package blog.techrevel.component.impl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

@Component(property = { "testProperty1=Hello", "testProperty2=World" })
public class MultipleComponentPropertiesImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(MultipleComponentPropertiesImpl.class);

	@Activate
	protected void activate(ComponentContext componentContext) {
		LOGGER.info("Registering: " + componentContext.getProperties().get("testProperty1").toString());
		LOGGER.info("Registering: " + componentContext.getProperties().get("testProperty2").toString());

	}

	@Deactivate
	protected void deactivate(ComponentContext componentContext) {
		LOGGER.info("Deregistering: " + componentContext.getProperties().get("testProperty1").toString());
		LOGGER.info("DeRegistering: " + componentContext.getProperties().get("testProperty2").toString());

	}
}
