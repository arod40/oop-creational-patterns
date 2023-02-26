package edu.baylor.ecs.csi5324.abstractFactory;

import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.product.impl.EbayProduct;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;
import edu.baylor.ecs.csi5324.abstractFactory.store.impl.Ebay;

public class EbayUserTest extends UserTest {

	// pick a store
	protected Store makeStore() {
		// Walmart();
		return new Ebay();
	}

	protected Product makeProduct(String name) {
		return new EbayProduct(name);
	}



}
