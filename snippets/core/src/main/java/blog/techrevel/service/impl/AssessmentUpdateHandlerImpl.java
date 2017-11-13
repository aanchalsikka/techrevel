package blog.techrevel.service.impl;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blog.techrevel.service.CourseImport;
import blog.techrevel.service.CourseImportHandler;

@Component(immediate = true, service = CourseImportHandler.class)
public class AssessmentUpdateHandlerImpl implements CourseImportHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentUpdateHandlerImpl.class);

	@Reference(target="(|(type=p*)(type=generic))")
	private CourseImport courseImport;
	
	@Override
	public void importContent() {
		courseImport.importContent();
	}
	
	@Activate
	protected void activate(ComponentContext componentContext) {
		courseImport.importContent();
	}
}