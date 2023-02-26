package edu.baylor.ecs.csi5324.abstractFactory.store.impl;

import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.DHL;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.DPD;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.UPS;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;

import java.util.Arrays;
import java.util.List;

public class Amazon  extends Store {

  private List<Distributor> distributorList = null;

  public Amazon() {
    Distributor[] distributors = { new DHL(), new DPD(), new UPS() };
    distributorList = Arrays.asList(distributors);
  }

  public Amazon(List<Distributor> distributorList) { this.distributorList = distributorList; }

  @Override
  public List<Distributor> getDistributorList() { return distributorList; }
}
