package blog.techrevel.component.impl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

@Component(property = { "testProperty1=hello", "testProperty2=A", "testProperty2=B", "testProperty2=C" })
public class ComponentMultivaluedPropertyImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentMultivaluedPropertyImpl.class);

	@Activate
	protected void activate(ComponentContext componentContext) {
		LOGGER.info("Registering: " + componentContext.getProperties().get("testProperty1").toString());
		Object[] arr = convertToObjectArray(componentContext.getProperties().get("testProperty2"));
		for (Object obj : arr) {
			LOGGER.info("Registering testProperty2: " + obj);
		}
	}

	@Deactivate
	protected void deactivate(ComponentContext componentContext) {
		LOGGER.info("Deregistering: " + componentContext.getProperties().get("testProperty1").toString());
		Object[] arr = convertToObjectArray(componentContext.getProperties().get("testProperty2"));
		for (Object obj : arr) {
			LOGGER.info("DeRegistering testProperty2: " + obj);
		}
	}

	static Object[] convertToObjectArray(Object array) {
		Class ofArray = array.getClass().getComponentType();
		if (ofArray.isPrimitive()) {
			List ar = new ArrayList();
			int length = Array.getLength(array);
			for (int i = 0; i < length; i++) {
				ar.add(Array.get(array, i));
			}
			return ar.toArray();
		} else {
			return (Object[]) array;
		}
	}
}
