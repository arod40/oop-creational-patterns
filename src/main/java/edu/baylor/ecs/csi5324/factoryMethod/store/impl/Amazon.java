package edu.baylor.ecs.csi5324.factoryMethod.store.impl;

import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.impl.DHL;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.impl.DPD;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.impl.UPS;
import edu.baylor.ecs.csi5324.factoryMethod.store.Store;

import java.util.Arrays;
import java.util.List;

public class Amazon  extends Store {

  private List<Distributor> distributorList = null;

  public Amazon() {
    Distributor[] distributors = { new DHL(), new DPD(), new UPS() };
    distributorList = Arrays.asList(distributors);
  }

  @Override
  public List<Distributor> getDistributorList() { return distributorList; }
}
