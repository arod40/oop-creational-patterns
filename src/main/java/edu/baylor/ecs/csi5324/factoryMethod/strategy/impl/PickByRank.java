package edu.baylor.ecs.csi5324.factoryMethod.strategy.impl;

import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;
import edu.baylor.ecs.csi5324.factoryMethod.strategy.Strategy;

import java.util.List;

public class PickByRank extends Strategy {
  public int selectDistributorIndex(List<Distributor> distributors) {
    int index = 0;
    double rank = 0;
    for (int i = 0; i < distributors.size(); i++) {
      Distributor distributor = distributors.get(i);
      if (distributor.getRank() > rank) {
        index = i;
        rank = distributor.getRank();
      }
      // TODO use logger!
      System.out.println("* " + distributor.getClass().getSimpleName());
    }
    return index;
  }
}
