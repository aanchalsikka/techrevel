package blog.techrevel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blog.techrevel.service.CourseImport;
import blog.techrevel.service.CourseImportHandler;

@Component(name = "courseImportHandler", immediate = true, service=CourseImportHandler.class)
public class CourseImportHandlerImpl implements CourseImportHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseImportHandlerImpl.class);

	private List<CourseImport> courseImportImplList;

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	protected void bind(CourseImport courseImport) {
		if (courseImportImplList == null) {
			courseImportImplList = new ArrayList<CourseImport>();
		}
		courseImportImplList.add(courseImport);
	}

	protected void unbind(CourseImport courseImport) {
		courseImportImplList.remove(courseImport);
	}

	@Override
	public void importContent() {
		for (CourseImport courseImportImpl : courseImportImplList) {
			if (courseImportImpl.canProcess("introduction.mp4")) {
				courseImportImpl.importContent();
				break;
			}
		}
	}
}