package edu.baylor.ecs.csi5324.factoryMethod.store.impl;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;
import edu.baylor.ecs.csi5324.factoryMethod.cart.CartLineItem;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.impl.DHL;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.impl.DPD;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.impl.UPS;
import edu.baylor.ecs.csi5324.factoryMethod.product.Product;
import edu.baylor.ecs.csi5324.factoryMethod.product.impl.EbayProduct;
import edu.baylor.ecs.csi5324.factoryMethod.store.Store;
import edu.baylor.ecs.csi5324.factoryMethod.strategy.impl.PickByPrice;

public class Ebay extends Store {
	private static final Logger LOGGER = Logger.getLogger( Ebay.class.getName());

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
		LOGGER.log(Level.INFO, Ebay.class.getSimpleName() + " is happy for your order");
		for (CartLineItem line : order.getOrderList()) {
			Product product = line.getProduct();
			LOGGER.log(Level.INFO, "* " + product.getName() + " " + line.getQuantity() + "x " + product.getPrice());
			if (product instanceof EbayProduct) {
				LOGGER.log(Level.INFO, "- Rank... " + ((EbayProduct) product).getRank());
			} else {
				throw new Exception("Not a eBay product");
			}

		}
		LOGGER.log(Level.INFO, "Total: " + order.getTotal());

	}

}
