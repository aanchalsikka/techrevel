package blog.techrevel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blog.techrevel.service.ConfigurationFactory;
import blog.techrevel.service.ConfigurationFactoryConsumer;

@Component(immediate = true, service = ConfigurationFactoryConsumer.class)
public class ConfigurationFactoryConsumerImpl implements ConfigurationFactoryConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationFactoryConsumerImpl.class);
	private List<ConfigurationFactory> configurationList;

	/**
	 * Executed on Configuration Add event
	 * @param config New configuration for factory
	 */
	@Reference(name = "configurationFactory", cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	protected synchronized void bindConfigurationFactory(final ConfigurationFactory config) {
		LOGGER.info("bindConfigurationFactory: " + config.getContentConsumerUrl());

		if (configurationList == null) {
			configurationList = new ArrayList<ConfigurationFactory>();
		}
		configurationList.add(config);
	}

	/**
	 * Executed on Configuration Remove event
	 * @param config New configuration for factory
	 */
	protected synchronized void unbindConfigurationFactory(final ConfigurationFactory config) {
		LOGGER.info("unbindConfigurationFactory: " + config.getContentConsumerUrl());
		configurationList.remove(config);
	}
}