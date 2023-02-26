package edu.baylor.ecs.csi5324.abstractFactory.strategy.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;
import edu.baylor.ecs.csi5324.abstractFactory.strategy.Strategy;

import java.util.List;

public class PickByRank extends Strategy {
  private static final Logger LOGGER = Logger.getLogger(PickByRank.class.getName());
  public int selectDistributorIndex(List<Distributor> distributors) {
    int index = 0;
    double rank = 0;
    for (int i = 0; i < distributors.size(); i++) {
      Distributor distributor = distributors.get(i);
      if (distributor.getRank() > rank) {
        index = i;
        rank = distributor.getRank();
      }
      LOGGER.log(Level.INFO, "* " + distributor.getClass().getSimpleName());
    }
    return index;
  }
}
