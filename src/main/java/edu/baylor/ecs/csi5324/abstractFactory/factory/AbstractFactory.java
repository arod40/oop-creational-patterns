package edu.baylor.ecs.csi5324.abstractFactory.factory;

import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;

import java.util.List;

public abstract class AbstractFactory {

  protected abstract List makeDistributorList();

  public abstract Product makeProduct(String name);

  public abstract Store makeStore();
}
