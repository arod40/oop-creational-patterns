package edu.baylor.ecs.csi5324.abstractFactory.distributor.impl;

import java.math.BigDecimal;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;
import edu.baylor.ecs.csi5324.abstractFactory.cart.Cart;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;
import edu.baylor.ecs.csi5324.factoryMethod.store.impl.Ebay;

public class DPD extends Distributor {

	private static final Logger LOGGER = Logger.getLogger( DPD.class.getName());
	@Override
	public BigDecimal getCharge() {
		// location estimate
		return new BigDecimal(130);
	}

	@Override
	public double getRank() {
		// some more detailed calculation
		return 4.6;
	}

	@Override
	public URL getTrackingLink() throws Exception {
		return new URL("http://www.dpd.com/tracking");
	}

	@Override
	public void ship(Cart order) throws Exception {
		shipTracing("DPD", order);
		LOGGER.log(Level.INFO, "# Pickup at vendor");
		LOGGER.log(Level.INFO, "# Send to Customer");
	}

}
