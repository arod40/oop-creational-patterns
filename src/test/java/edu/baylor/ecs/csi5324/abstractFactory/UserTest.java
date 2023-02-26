package edu.baylor.ecs.csi5324.abstractFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import edu.baylor.ecs.csi5324.abstractFactory.factory.AbstractFactory;
import edu.baylor.ecs.csi5324.abstractFactory.factory.impl.EbayFactory;
import edu.baylor.ecs.csi5324.abstractFactory.strategy.Strategy;
import edu.baylor.ecs.csi5324.abstractFactory.strategy.impl.PickByRank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import edu.baylor.ecs.csi5324.abstractFactory.cart.Cart;
import edu.baylor.ecs.csi5324.abstractFactory.product.Product;
import edu.baylor.ecs.csi5324.abstractFactory.store.Store;
import edu.baylor.ecs.csi5324.abstractFactory.store.impl.Ebay;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {
	protected AbstractFactory factory;

	private Product soap;
	private Product anotherSoap;
	private Product tabaco;
	private Product book;
	private Product lego;


	protected void makeFactory(){
		// I put Ebay factory by default so that it runs, but the idea is that each client class
		// defines its own factory.
		factory = new EbayFactory();
	};

	@BeforeAll
	public void setUp() {
		makeFactory();

		soap = factory.makeProduct("Soap").init("Nice protocol", new BigDecimal(30));
		anotherSoap = factory.makeProduct("Soap").init("Nice protocol", new BigDecimal(30));
		tabaco = factory.makeProduct("Tabaco").init("Dont smoke", new BigDecimal(20));
		book = factory.makeProduct("Book").init("Read me", new BigDecimal(25));
		lego = factory.makeProduct("Lego").init("Play me", new BigDecimal(35));

	}

	@Test
	public void test() throws Exception {

		Store store = factory.makeStore();
		Cart cart = makeAnOrder();
		selectDistributorBasedOnRank(store);

		// process
		store.process(cart);

	}

	@Test
	public void testFail() throws Exception {

		Store store = factory.makeStore();
		Cart cart = makeAnOrder();
		// try to process
		assertThrows(Exception.class, () -> {
			store.process(cart);
		});

	}

	@Test
	public void testAggregation() throws Exception {
		Cart cart = makeAnOrder();
		assertTrue(cart.getOrderList().size() == 4);
	}

	@Test
	public void testTotal() throws Exception {
		Cart cart = makeAnOrder();
		assertTrue(cart.getTotal().equals(new BigDecimal("190")));
	}

	protected Cart makeAnOrder() {
		// make an order
		Cart cart = new Cart();
		return cart.addLine(soap, 2)
				.addLine(anotherSoap, 1)
				.addLine(tabaco, 2)
				.addLine(lego, 1)
				.addLine(book, 1);
	}

	private void selectDistributorBasedOnRank(Store store) {
		Strategy strategy = new PickByRank();
		int index =strategy.selectDistributorIndex(store.getDistributorList());
		store.selectDistributor(index);
	}
}
