package edu.baylor.ecs.csi5324.factoryMethod.distributor.impl;

import java.math.BigDecimal;
import java.net.URL;

import com.sun.media.jfxmedia.logging.Logger;
import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;

public class USPS extends Distributor {

	@Override
	public BigDecimal getCharge() {
		// location estimate
		return new BigDecimal(150);
	}

	@Override
	public double getRank() {
		// some more detailed calculation
		return 2.5;
	}

	@Override
	public URL getTrackingLink() throws Exception {
		return new URL("http://www.usps.com/tracking");
	}

	@Override
	public void ship(Cart order) throws Exception {
		shipTracing("usps", order);
		Logger.logMsg(Logger.INFO, "# Send to Chicago");
		Logger.logMsg(Logger.INFO, "# Distribute locally");
		Logger.logMsg(Logger.INFO, "# Distribute locally");
		Logger.logMsg(Logger.INFO, "# Distribute locally");
		Logger.logMsg(Logger.INFO, "# Send to Customer");
	}

}
