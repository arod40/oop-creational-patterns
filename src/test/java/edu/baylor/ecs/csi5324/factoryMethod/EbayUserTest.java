package edu.baylor.ecs.csi5324.factoryMethod;

import edu.baylor.ecs.csi5324.factoryMethod.product.Product;
import edu.baylor.ecs.csi5324.factoryMethod.product.impl.EbayProduct;
import edu.baylor.ecs.csi5324.factoryMethod.store.Store;
import edu.baylor.ecs.csi5324.factoryMethod.store.impl.Ebay;

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
