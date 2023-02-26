package edu.baylor.ecs.csi5324.factoryMethod;

import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;
import edu.baylor.ecs.csi5324.factoryMethod.product.Product;
import edu.baylor.ecs.csi5324.factoryMethod.product.impl.AmazonProduct;
import edu.baylor.ecs.csi5324.factoryMethod.product.impl.EbayProduct;
import edu.baylor.ecs.csi5324.factoryMethod.store.Store;
import edu.baylor.ecs.csi5324.factoryMethod.store.impl.Amazon;
import edu.baylor.ecs.csi5324.factoryMethod.store.impl.Ebay;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AmazonUserTest extends UserTest {

  // pick a store
  protected Store makeStore() {
    // Walmart();
    return new Amazon();
  }

  protected Product makeProduct(String name) {
    return new AmazonProduct(name);
  }

  @Test
  public void testTotal() throws Exception {
    Cart cart = makeAnOrder();
    assertTrue(cart.getTotal().equals(new BigDecimal("190").multiply(new BigDecimal("0.9"))));
  }



}
