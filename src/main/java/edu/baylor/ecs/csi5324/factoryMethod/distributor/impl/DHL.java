package edu.baylor.ecs.csi5324.factoryMethod.distributor.impl;

import java.math.BigDecimal;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.baylor.ecs.csi5324.abstractFactory.strategy.impl.PickByPrice;
import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;

public class DHL extends Distributor {
	private static final Logger LOGGER = Logger.getLogger(DHL.class.getName());

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
		LOGGER.log(Level.INFO, "# Pickup at vendor");
		LOGGER.log(Level.INFO, "# Send to Uvaly");
		LOGGER.log(Level.INFO, "# Distribute locally");
		LOGGER.log(Level.INFO, "# Send to Customer");
	}

}
