package blog.techrevel.service.impl;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blog.techrevel.service.BundleInfo;

@Component(immediate = true, service=BundleInfo.class)
public class BundleInfoImpl implements BundleInfo {
	private static final Logger LOG = LoggerFactory.getLogger(BundleInfoImpl.class);
	private static BundleContext bundleContext;

	@Override
	public void getBundleInfo(BundleContext bundleContext) {
		Bundle[] bundles = bundleContext.getBundles();

		for (Bundle bundle : bundles) {
			//Bundle details
			LOG.debug("State: " + bundle.getState());
			LOG.debug("Symbolic name: " + bundle.getSymbolicName());
			LOG.debug("Version:" + bundle.getHeaders().get(Constants.BUNDLE_VERSION).toString());
			LOG.debug("Imported Packages:" + bundle.getHeaders().get(Constants.IMPORT_PACKAGE));

			extractServicesInfo(bundle);
		}
	}
	
	// Fetching ServiceReferernces exposed by the bundle
	public static void extractServicesInfo(Bundle bundle) {
		ServiceReference[] registeredServices = bundle.getRegisteredServices();
		if (registeredServices != null) {
			for (ServiceReference registeredService : bundle.getRegisteredServices()) {
				// Fetching any property of the Service
				LOG.debug("service.pid: " + registeredService.getProperty("service.pid"));

				// Fetch Service from ServiceReference
				LOG.debug("Service: " + bundleContext.getService(registeredService));
			}
		}
	}

	@Activate
	
	protected void activate(ComponentContext cc) {
		bundleContext = cc.getBundleContext();
		getBundleInfo(bundleContext);
	}
}