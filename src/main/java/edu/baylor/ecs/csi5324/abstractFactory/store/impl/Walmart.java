package edu.baylor.ecs.csi5324.abstractFactory.store.impl;

import java.util.Arrays;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import edu.baylor.ecs.csi5324.abstractFactory.cart.Cart;
import edu.baylor.ecs.csi5324.abstractFactory.cart.CartLineItem;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.UPS;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.USPS;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.DPD;
import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;

public class Walmart extends Store {

	private List<Distributor> distributorList = null;

	public Walmart() {
		Distributor[] distributors = { new USPS(), new DPD(), new UPS() };
		distributorList = Arrays.asList(distributors);
	}

	public Walmart(List<Distributor> distributorList) {
		this.distributorList = distributorList;
	}

	@Override
	public List<Distributor> getDistributorList() {
		return distributorList;
	}

	@Override
	protected void hookProcess(Cart order) throws Exception {
		Logger.logMsg(Logger.INFO, Walmart.class.getSimpleName() + " is happy for your order");
		for (CartLineItem line : order.getOrderList()) {
			Product product = line.getProduct();
			Logger.logMsg(Logger.INFO, "+ " + product.getName() + " " + line.getQuantity() + "x " + product.getPrice());

		}
		Logger.logMsg(Logger.INFO, "Total: " + order.getTotal());

	}

}
