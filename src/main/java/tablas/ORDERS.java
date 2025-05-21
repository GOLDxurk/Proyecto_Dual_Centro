package Tablas;
import java.util.Date;
public class ORDERS {
	int order_id;
	int customer_id;
	String status;
	int salesman_id;
	Date order_date;
	int fk_orders_customers;
	int fk_orders_employees;

	// constructor vacio
	public ORDERS() {
		super();
	}

	// constructor con pk
	public ORDERS(int order_id, int customer_id, String status, int salesman_id, Date order_date,
			int fk_orders_customers, int fk_orders_employees) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.status = status;
		this.salesman_id = salesman_id;
		this.order_date = order_date;
		this.fk_orders_customers = fk_orders_customers;
		this.fk_orders_employees = fk_orders_employees;
	}

	// constructor sin pk
	public ORDERS(int customer_id, String status, int salesman_id,Date order_date, int fk_orders_customers,
			int fk_orders_employees) {
		super();
		this.customer_id = customer_id;
		this.status = status;
		this.salesman_id = salesman_id;
		this.order_date = order_date;
		this.fk_orders_customers = fk_orders_customers;
		this.fk_orders_employees = fk_orders_employees;
	}

	// setters y getters
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSalesman_id() {
		return salesman_id;
	}

	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getFk_orders_customers() {
		return fk_orders_customers;
	}

	public void setFk_orders_customers(int fk_orders_customers) {
		this.fk_orders_customers = fk_orders_customers;
	}

	public int getFk_orders_employees() {
		return fk_orders_employees;
	}

	public void setFk_orders_employees(int fk_orders_employees) {
		this.fk_orders_employees = fk_orders_employees;
	}

	// Resumen propiedades con toString
	@Override
	public String toString() {
		return "ORDERS [order_id=" + order_id + ", customer_id=" + customer_id + ", status=" + status + ", salesman_id="
				+ salesman_id + ", order_date=" + order_date + ", fk_orders_customers=" + fk_orders_customers
				+ ", fk_orders_employees=" + fk_orders_employees + "]";
	}

}
