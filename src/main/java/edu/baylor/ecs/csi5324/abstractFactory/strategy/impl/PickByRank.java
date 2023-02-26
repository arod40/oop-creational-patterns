package edu.baylor.ecs.csi5324.abstractFactory.strategy.impl;

import com.sun.media.jfxmedia.logging.Logger;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;
import edu.baylor.ecs.csi5324.abstractFactory.strategy.Strategy;

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
      Logger.logMsg(Logger.INFO, "* " + distributor.getClass().getSimpleName());
    }
    return index;
  }
}
