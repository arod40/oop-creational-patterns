package edu.baylor.ecs.csi5324.abstractFactory.store.impl;

import java.util.Arrays;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;
import edu.baylor.ecs.csi5324.abstractFactory.cart.Cart;
import edu.baylor.ecs.csi5324.abstractFactory.cart.CartLineItem;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.Distributor;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.DHL;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.DPD;
import edu.baylor.ecs.csi5324.abstractFactory.distributor.impl.UPS;
import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.product.impl.EbayProduct;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;

public class Ebay extends Store {

	private List<Distributor> distributorList = null;
	
	public Ebay() {
		Distributor[] distributors = { new DHL(), new DPD(), new UPS() };
		distributorList = Arrays.asList(distributors);
	}

	public Ebay(List<Distributor> distributorList) {
		this.distributorList = distributorList;
	}
	
	@Override
	public List<Distributor> getDistributorList() {
		return distributorList;
	}

	@Override
	protected void hookProcess(Cart order) throws Exception {
		Logger.logMsg(Logger.INFO, Ebay.class.getSimpleName() + " is happy for your order");
		for (CartLineItem line : order.getOrderList()) {
			Product product = line.getProduct();
			Logger.logMsg(Logger.INFO, "* " + product.getName() + " " + line.getQuantity() + "x " + product.getPrice());
			if (product instanceof EbayProduct) {
				Logger.logMsg(Logger.INFO, "- Rank... " + ((EbayProduct) product).getRank());
			} else {
				throw new Exception("Not a eBay product");
			}

		}
		Logger.logMsg(Logger.INFO, "Total: " + order.getTotal());

	}

}
