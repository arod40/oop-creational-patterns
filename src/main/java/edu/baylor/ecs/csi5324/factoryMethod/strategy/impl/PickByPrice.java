package edu.baylor.ecs.csi5324.factoryMethod.strategy.impl;

import com.sun.media.jfxmedia.logging.Logger;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;
import edu.baylor.ecs.csi5324.factoryMethod.strategy.Strategy;

import java.math.BigDecimal;
import java.util.List;

public class PickByPrice extends Strategy {
  public int selectDistributorIndex(List<Distributor> distributors) {
    int index = 0;
    BigDecimal charge = new BigDecimal("0");
    for (int i = 0; i < distributors.size(); i++) {
      Distributor distributor = distributors.get(i);
      if (distributor.getCharge().compareTo(charge) > 0) {
        index = i;
        charge = distributor.getCharge();
      }
      Logger.logMsg(Logger.INFO, "* " + distributor.getClass().getSimpleName());
    }
    return index;
  }
}
