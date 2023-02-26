package edu.baylor.ecs.csi5324.abstractFactory;

import edu.baylor.ecs.csi5324.abstractFactory.factory.AbstractFactory;
import edu.baylor.ecs.csi5324.abstractFactory.factory.impl.EbayFactory;
import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.product.impl.EbayProduct;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;
import edu.baylor.ecs.csi5324.abstractFactory.store.impl.Ebay;

public class EbayUserTest extends UserTest {
	protected void makeFactory() {
		this.factory = new EbayFactory();
	}
}
