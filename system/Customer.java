package system;

public class Customer {
	String id;
	String name;
	String email;
	String phone;
	String address;
    int numOfReq;
	public Customer(String id,String name,String email,int numOfReq,String phone,String address) {
		this.id=id;
		this.email=email;
		this.name=name;
		this.phone=phone;
		this.address=address;
		this.numOfReq=numOfReq;
	}
	  public void setName(String name) {
	        this.name = name;
	    }

	    public void setUserName(String email) {
	        this.email = email;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public void setNumOfReq(Integer numOfReq) {
	        this.numOfReq = numOfReq;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getUserName() {
	        return email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public Integer getNumOfReq() {
	        return numOfReq;
	    }

	public boolean hasDiscount() {
		boolean hasDiscount;
		if(numOfReq >=5)
			hasDiscount = true;
		else
			hasDiscount=false;
		
	return hasDiscount;	
	}

		
		
	
	
}
