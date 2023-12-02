package system;

public class order {
	private int orderId;
    private String product;
    private double price;
    private String orderDate; 

    public order(int orderId, String product, double price, String orderDate) {
        this.orderId = orderId;
        this.product = product;
        this.price = price;
        this.orderDate = orderDate;
    }
}
