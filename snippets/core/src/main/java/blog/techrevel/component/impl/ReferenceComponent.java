package blog.techrevel.component.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blog.techrevel.service.ConfigurationFactory;
import blog.techrevel.service.CourseImport;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReferenceComponent {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReferenceComponent.class);

	private List<CourseImport> courseImportList;
	private List<ConfigurationFactory> configurationList;

	@Reference(name = "courseImport", cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	protected void bind(CourseImport courseImport) {
		LOGGER.info("bindCourseImport: " + courseImport);

		if (courseImportList == null) {
			courseImportList = new ArrayList<CourseImport>();
		}
		courseImportList.add(courseImport);
	}

	protected void unbind(CourseImport courseImport) {
		LOGGER.info("UnBind courseImport:" + courseImport);
	}

	@Reference(name = "configurationFactory", cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	protected void bind(ConfigurationFactory config) {
		LOGGER.info("bindConfigurationFactory: " + config.getContentConsumerUrl());

		if (configurationList == null) {
			configurationList = new ArrayList<ConfigurationFactory>();
		}
		configurationList.add(config);
	}

	protected void unbind(ConfigurationFactory obj) {
		LOGGER.info("UnBind ConfigurationFactory:" + obj);
	}
}