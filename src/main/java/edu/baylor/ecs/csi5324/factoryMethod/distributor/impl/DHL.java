package edu.baylor.ecs.csi5324.factoryMethod.distributor.impl;

import java.math.BigDecimal;
import java.net.URL;

import com.sun.media.jfxmedia.logging.Logger;
import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;

public class DHL extends Distributor {

	@Override
	public BigDecimal getCharge() {
		// location estimate
		return new BigDecimal(120);
	}

	@Override
	public double getRank() {
		// some more detailed calculation
		return 4.5;
	}

	@Override
	public URL getTrackingLink() throws Exception {
		return new URL("http://www.dhl.com/tracking");
	}

	@Override
	public void ship(Cart order) throws Exception {
		shipTracing("DHL", order);
		Logger.logMsg(Logger.INFO, "# Pickup at vendor");
		Logger.logMsg(Logger.INFO, "# Send to Uvaly");
		Logger.logMsg(Logger.INFO, "# Distribute locally");
		Logger.logMsg(Logger.INFO, "# Send to Customer");
	}

}
