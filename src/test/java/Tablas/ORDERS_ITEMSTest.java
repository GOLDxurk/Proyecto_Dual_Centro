package Tablas;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ORDERS_ITEMSTest {

	private ORDERS_ITEMS item;

	@BeforeEach
	public void setUp() {
		item = new ORDERS_ITEMS();
	}

	@Test
	public void testConstructorVacio() {
		ORDERS_ITEMS item = new ORDERS_ITEMS();
		assertThat(item, is(notNullValue()));
	}

	@Test
	public void testConstructorConPK() {
		ORDERS_ITEMS item = new ORDERS_ITEMS(100, 1, 200, 5.0, 10.0, 300, 400);

		assertThat(item.getOrder_id(), is(100));
		assertThat(item.getItem_id(), is(1));
		assertThat(item.getProduct_id(), is(200));
		assertThat(item.getQuantity(), is(5.0));
		assertThat(item.getUnit_price(), is(10.0));
		assertThat(item.getFk_order_items(), is(300));
		assertThat(item.getFk_order_items_order(), is(400));
	}

	@Test
	public void testConstructorSinPK() {
		ORDERS_ITEMS item = new ORDERS_ITEMS(2, 201, 3.0, 20.0, 301, 401);

		assertThat(item.getOrder_id(), is(0));
		assertThat(item.getItem_id(), is(2));
		assertThat(item.getProduct_id(), is(201));
		assertThat(item.getQuantity(), is(3.0));
		assertThat(item.getUnit_price(), is(20.0));
		assertThat(item.getFk_order_items(), is(301));
		assertThat(item.getFk_order_items_order(), is(401));
	}

	@Test
	public void testSetAndGetOrderId() {
		item.setOrder_id(3001);
		assertThat(item.getOrder_id(), is(3001));
	}

	@Test
	public void testSetAndGetItemId() {
		item.setItem_id(1);
		assertThat(item.getItem_id(), is(1));
	}

	@Test
	public void testSetAndGetProductId() {
		item.setProduct_id(12);
		assertThat(item.getProduct_id(), is(12));
	}

	@Test
	public void testSetAndGetQuantity() {
		item.setQuantity(5);
		assertThat((double) item.getQuantity(), greaterThan(0.0));
	}

	@Test
	public void testSetAndGetUnitPrice() {
		item.setUnit_price(45.0);
		assertThat(item.getUnit_price(), greaterThanOrEqualTo(0.0));
	}

	@Test
	public void testSetAndGetFk_order_items() {
		item.setFk_order_items(302);
		assertThat(item.getFk_order_items(), is(302));
	}

	@Test
	public void testSetAndGetFk_order_items_order() {
		item.setFk_order_items_order(402);
		assertThat(item.getFk_order_items_order(), is(402));
	}

	@Test
	public void testToStringContainsAll() {
		item.setOrder_id(100);
		item.setItem_id(1);
		item.setProduct_id(200);
		item.setQuantity(10.0);
		item.setUnit_price(20.0);
		item.setFk_order_items(300);
		item.setFk_order_items_order(400);
		assertThat(item.toString(), containsString("100"));
		assertThat(item.toString(), containsString("1"));
		assertThat(item.toString(), containsString("200"));
		assertThat(item.toString(), containsString("10.0"));
		assertThat(item.toString(), containsString("20.0"));
		assertThat(item.toString(), containsString("300"));
		assertThat(item.toString(), containsString("400"));
	}
}
