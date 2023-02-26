package edu.baylor.ecs.csi5324.abstractFactory.factory.impl;

import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.DHL;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.DPD;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.UPS;
import edu.baylor.ecs.csi5324.abstractFactory.factory.AbstractFactory;
import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.product.impl.AmazonProduct;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;
import edu.baylor.ecs.csi5324.abstractFactory.store.impl.Amazon;

import java.util.Arrays;
import java.util.List;

public class AmazonFactory extends AbstractFactory {
  @Override
  protected List makeDistributorList() {
    Distributor[] distributors = { new UPS() };
    return Arrays.asList(distributors);
  }

  @Override
  public Product makeProduct(String name) {
    return new AmazonProduct(name);
  }

  @Override
  public Store makeStore() {
    return new Amazon(makeDistributorList());
  }
}
