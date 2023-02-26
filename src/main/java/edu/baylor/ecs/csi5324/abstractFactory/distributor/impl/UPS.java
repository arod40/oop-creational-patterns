package edu.baylor.ecs.csi5324.abstractFactory.distributor.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import edu.baylor.ecs.csi5324.abstractFactory.cart.Cart;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;

import java.math.BigDecimal;
import java.net.URL;

public class UPS extends Distributor {
  private static final Logger LOGGER = Logger.getLogger(UPS.class.getName());
  @Override
  public BigDecimal getCharge() {
    return new BigDecimal(160);
  }

  @Override
  public double getRank() {
    return 3.5;
  }

  @Override
  public URL getTrackingLink() throws Exception {
    return new URL("http://www.ups.com/track");
  }

  @Override
  public void ship(Cart cart) throws Exception {
    shipTracing("USPS", cart);
    LOGGER.log(Level.INFO, "# Pickup at vendor");
    LOGGER.log(Level.INFO, "# Send to Customer");
  }
}
