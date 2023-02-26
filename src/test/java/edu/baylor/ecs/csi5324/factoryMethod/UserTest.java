package edu.baylor.ecs.csi5324.factoryMethod;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import edu.baylor.ecs.csi5324.factoryMethod.strategy.Strategy;
import edu.baylor.ecs.csi5324.factoryMethod.strategy.impl.PickByRank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import edu.baylor.ecs.csi5324.factoryMethod.cart.Cart;
import edu.baylor.ecs.csi5324.factoryMethod.distributor.Distributor;
import edu.baylor.ecs.csi5324.factoryMethod.product.Product;
import edu.baylor.ecs.csi5324.factoryMethod.store.Store;
import edu.baylor.ecs.csi5324.factoryMethod.store.impl.Ebay;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

	private Product soap;
	private Product anotherSoap;
	private Product tabaco;
	private Product book;
	private Product lego;

	// pick a store
	protected Store makeStore() {
		// Walmart();
		return new Ebay();
	}

	protected Product makeProduct(String name) {
		return new Product(name);
	}

	@BeforeAll
	public void setUp() {
		// pick product type
		// what if ebay product?

		soap = makeProduct("Soap").init("Nice protocol", new BigDecimal(30));
		anotherSoap = makeProduct("Soap").init("Nice protocol", new BigDecimal(30));
		tabaco = makeProduct("Tabaco").init("Dont smoke", new BigDecimal(20));
		book = makeProduct("Book").init("Read me", new BigDecimal(25));
		lego = makeProduct("Lego").init("Play me", new BigDecimal(35));

	}

	@Test
	public void test() throws Exception {
		Store store = makeStore();
		Cart cart = makeAnOrder();
		selectDistributorBasedOnRank(store);

		// process
		store.process(cart);

	}

	@Test
	public void testFail() throws Exception {

		Store store = makeStore();
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
