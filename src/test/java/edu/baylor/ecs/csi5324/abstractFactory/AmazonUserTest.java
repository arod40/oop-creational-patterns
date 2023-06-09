package edu.baylor.ecs.csi5324.abstractFactory;

import edu.baylor.ecs.csi5324.abstractFactory.cart.Cart;
import edu.baylor.ecs.csi5324.abstractFactory.factory.impl.AmazonFactory;
import edu.baylor.ecs.csi5324.abstractFactory.factory.impl.EbayFactory;
import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.product.impl.AmazonProduct;
import edu.baylor.ecs.csi5324.abstractFactory.product.impl.EbayProduct;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;
import edu.baylor.ecs.csi5324.abstractFactory.store.impl.Amazon;
import edu.baylor.ecs.csi5324.factoryMethod.store.impl.Ebay;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AmazonUserTest extends UserTest {
  protected void makeFactory() {
    this.factory = new AmazonFactory();
  }

  @Test
  public void testTotal() throws Exception {
    Cart cart = makeAnOrder();
    assertTrue(cart.getTotal().equals(new BigDecimal("190").multiply(new BigDecimal("0.9"))));
  }



}
