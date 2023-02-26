package edu.baylor.ecs.csi5324.factoryMethod.distributor;

import java.math.BigDecimal;
import java.net.URL;

import com.sun.media.jfxmedia.logging.Logger;
import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;

/**
 * Pluggable store distributor
 *
 */
public abstract class Distributor {
	
	
	/**
	 * @return cost of the shipment
	 */
	public abstract BigDecimal getCharge();

	/**
	 * @return user rank
	 */
	public abstract double getRank();

	/**
	 * @return tracking URL
	 * @throws Exception
	 */
	public abstract URL getTrackingLink() throws Exception;

	/**
	 * Shipping a cart
	 * @param cart
	 * @throws Exception
	 */
	public abstract void ship(Cart cart) throws Exception;

	/*
	 * 
	 */
	protected void shipTracing(String name, Cart cart) throws Exception {
		Logger.logMsg(Logger.INFO, name + " ships (" + cart.getTotal() + ") for charge " + getCharge() + " track at "
								   + getTrackingLink().toString());
	}
}
