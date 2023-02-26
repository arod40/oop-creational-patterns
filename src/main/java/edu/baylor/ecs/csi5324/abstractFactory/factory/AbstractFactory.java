package edu.baylor.ecs.csi5324.abstractFactory.factory;

import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;
import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractFactory {

  Map<String, Product> cache = new HashMap();

  protected abstract List<Distributor> makeDistributorList();

  protected abstract Product doMakeProduct(String name);

  public abstract Store makeStore();

  public final Product makeProduct(String name) {
     if (cache.containsKey(name)) {
        return cache.get(name);
     } else {
        Product product = doMakeProduct(name);
        cache.put(name, product);
        return product;
     }
  }
}
