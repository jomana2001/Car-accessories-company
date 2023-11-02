package system;

public class Order {
 
	String cId;
	String pId;
	String wId;
	Status status=Status.WAITING;
	int numOfOrder;
	int deliveryPrice;
	int productPrice;
	
	
	public Order(String oId,String cId,String pId,String wId,int numOfOrder,int deliveryPrice,int productPrice) {
		this.oId=oId;
		this.cId=cId;
		this.pId=pId;
		this.wId=wId;
		this.numOfOrder=numOfOrder;
		this.deliveryPrice=deliveryPrice;
		this.productPrice=productPrice;

	}
	public void setStatus(Status s) {
		status=s;
	}
	public Status getStatus() {
		return status;
	}
	
}
