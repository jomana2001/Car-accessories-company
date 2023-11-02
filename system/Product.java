package system;

public class Product {
	String id;
	String name;
	int price;
	
	public Product(String id, String name, int price2) {
		this.id=id;
		this.name=name;
		this.price=price2;
	}
	
	public void setName(String newValue) {
	    name = newValue;
	}

	public void setPrice(Integer valueOf) {
	    price = valueOf;
	}

	public void setId(String newValue) {
	    id = newValue;
	}

	public String getName() {
	    return name;
	}

	public Integer getPrice() {
	    return price;
	}

	public String getId() {
	    return id;
	}
	
	
	
	
	
	

	
}
