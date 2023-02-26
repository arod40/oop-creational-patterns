package edu.baylor.ecs.csi5324.factoryMethod.distributor.impl;

import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;

import java.math.BigDecimal;
import java.net.URL;

public class UPS extends Distributor {
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
    System.out.println("# Pickup at vendor");
    System.out.println("# Send to Customer");
  }
}
