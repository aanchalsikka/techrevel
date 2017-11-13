package blog.techrevel.component.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Designate(ocd = ConfigurableComponentPorpertiesImpl.Config.class)
public class ConfigurableComponentPorpertiesImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurableComponentPorpertiesImpl.class);

	@ObjectClassDefinition(name = "Techrevel Sample Configuration", description = "This is sample configuration")
	public @interface Config {

		@AttributeDefinition(name = "Blog name", defaultValue = "techrevel", description = "Name of the blog")
		String blog_name();
		
		@AttributeDefinition(name = "Blog Url")
		String blog_URL() default "https://techrevel.blog";

		@AttributeDefinition(name = "Blog Count", description = "Total number of blogs")
		int blogCount() default 0;

	}

	@Activate
	protected void activate(final Config config) {
		LOGGER.info("Blog name: " + config.blog_name());
		LOGGER.info("Blog URL: " + config.blog_URL());
		LOGGER.info("Blog Count: " + config.blogCount());
	}
}
