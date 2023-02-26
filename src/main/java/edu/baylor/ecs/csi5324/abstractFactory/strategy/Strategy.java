package edu.baylor.ecs.csi5324.abstractFactory.strategy;

import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;

import java.util.List;

public abstract class Strategy {
  public abstract int selectDistributorIndex(List<Distributor> distributors);
}
