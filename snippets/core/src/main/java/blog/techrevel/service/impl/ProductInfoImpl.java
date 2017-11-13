package blog.techrevel.service.impl;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.license.ProductInfo;
import com.adobe.granite.license.ProductInfoProvider;

@Component(immediate = true, service = ProductInfoImpl.class)
public class ProductInfoImpl {
	private static final Logger LOG = LoggerFactory.getLogger(ProductInfoImpl.class);

	@Reference
	private ProductInfoProvider piProvider;

	@Activate
	protected void activate(ComponentContext cc) {
		if (piProvider != null) {
			ProductInfo pi = piProvider.getProductInfo();
			LOG.info("Product name: " + pi.getName());
			LOG.info("Product short name: " + pi.getShortName());
			LOG.info("Product version: " + pi.getVersion());
			LOG.info("Product short version: " + pi.getShortVersion());
		}
	}
}