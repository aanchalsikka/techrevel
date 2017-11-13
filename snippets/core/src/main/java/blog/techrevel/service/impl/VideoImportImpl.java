package blog.techrevel.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blog.techrevel.service.CourseImport;

@Component(name = "videos", service = CourseImport.class, property = { "type=video" })
public class VideoImportImpl implements CourseImport {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoImportImpl.class);

	@Override
	public void importContent() {
		LOGGER.info("Business Logic to import course videos");
	}

	@Override
	public boolean canProcess(String fileName) {
		return StringUtils.endsWith(fileName, ".mp4");
	}

	@Activate
	@Modified
	protected void activate(ComponentContext componentContext) {
		LOGGER.info("Registering: " + componentContext.getProperties().get("type").toString());
	}
}