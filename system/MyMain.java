package system;


import java.util.Scanner;

import java.util.logging.Logger;

public class MyMain {
	static final String ID1="123456";
	static final String ID2="113456";
	static final String BACK="You can enter B to back to the list !";
	static final String VALID="plz enter valid value!";
    private static final Logger LOGGER = Logger.getLogger(MyMain.class.getName());

	public static void list() {
		LOGGER.info("1- Add,Delete,Search,Update Customer "+"\n");
		LOGGER.info("2- Add,Delete,Search,Update Product "+"\n");
		LOGGER.info("3- add new order "+"\n");
		LOGGER.info("4- Report for the system "+"\n");
		LOGGER.info("5- Print total cash,paid,delivered items "+"\n");
		LOGGER.info("6- Logout "+"\n");

}
	public static void productList() {
		LOGGER.info("0-if he want to clean CARPET minimum than 9");
		LOGGER.info("1-if he want to clean CARPET greater than 9 and smaller than 16");
		LOGGER.info("2-if he want to clean CARPET greater than 16");
		LOGGER.info("3-if he want to clean SINGLE COVER");
		LOGGER.info("4-if he want to clean COUPLE COVER");
		LOGGER.info("5-if he want to clean CURTAIN");

	}
	
	public static void main(String[] args) {
		String header;
		MySystem system =new MySystem();
		system.customers.add(new Customer("id1","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab"));
		system.customers.add(new Customer("id2","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia"));
		system.customers.add(new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia"));
		
		system.products.add(new Product("0","CARPET minimum than 9",15));
		system.products.add(new Product("1","CARPET greater than 9 and smaller than 16",20));
		system.products.add(new Product("2","CARPET greater than 16",30));
		system.products.add(new Product("3","SINGLECOVER",13));
		system.products.add(new Product("4","COUPLECOVER",20));
		system.products.add(new Product("5","CURTAIN",8));
		
		system.workers.add(new Worker("123","hamza ahmad","0598937949","Rafedia",true));
		system.workers.add(new Worker("113","taher yaseen","0599894568","Rafedia",true));
		system.workers.add(new Worker("223","ayman mohammed","059378568","makhfia",true));
		
		Order order=new Order("1","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("2","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("3","id1","0","123",1,20,15);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("4","id1","2","445",1,20,30);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("5","id1","0","445",1,20,13);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("6","id1","5","123",1,12,8);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("7","id2","4","113",1,12,20);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		order=new Order("8","987654","4","113",1,0,20);
		order.setStatus(Status.COMPLETE);
		system.orders.add(order);
		
		Admin admin =new Admin ();
		Scanner con = new Scanner(System.in);
		LOGGER.info("Enter username:");
	    String username = con.nextLine();
	    LOGGER.info("Enter password:");
	    String password = con.nextLine();
	    
	    if(admin.login(username, password)) {
	    	
	    	list();
	    	while(true) {
	    	String choice=con.nextLine();
	    	
	    	if(choice.equals("1")) {
	    		LOGGER.info("Enter A for add , D for delete and U for update customer");	    		
	    		LOGGER.info(BACK);
	    		
	    		while (true) {
	    		    String s = con.nextLine();
	    		    if (s.equals("A")) {
	    		        String id;
	    		        String name;
	    		        String email;
	    		        String phone;
	    		        String address;
	    		        int numOfReq = 0;
	    		        LOGGER.info("insert his id");
	    		        id = con.nextLine();
	    		        LOGGER.info("insert his name");
	    		        name = con.nextLine();
	    		        LOGGER.info("insert his email");
	    		        email = con.nextLine();
	    		        LOGGER.info("insert his phone");
	    		        phone = con.nextLine();
	    		        LOGGER.info("insert his address");
	    		        address = con.nextLine();
	    		        Customer c = new Customer(id, name, email, numOfReq, phone, address);
	    		        boolean pr = system.register(c);
	    		        if(pr) {
	    		        LOGGER.info("Added successfully");}
	    		        else {
		    		        LOGGER.info("Customer already registered");}

	    		    } else if (s.equals("D")) {
	    		        LOGGER.info("insert the id for customer to delete him");
	    		        String id = con.nextLine();
	    		        String pr = system.deleteCustomer(id);
	    		        LOGGER.info(pr);
	    		    } else if (s.equals("U")) {
	    		        LOGGER.info("insert what you want to update ");
	    		        String whatUpdate = con.nextLine();
	    		        LOGGER.info("insert the id for customer ");
	    		        String id = con.nextLine();
	    		        LOGGER.info("insert the new value");
	    		        String newValue = con.nextLine();
	    		        boolean check =system.update(whatUpdate, id, newValue);
	    		        if(check) {
	    	    			LOGGER.info("Updated Successfully");}
	    	    			else {
	    	    				LOGGER.info("customer not valid");}
	    		    } else if (s.equals("B")) {
	    		        list();
	    		        break;
	    		    } else {
	    		        LOGGER.info(VALID);
	    		    }
	    		}
	    		}
	    	else if(choice.equals("2")) {
	    		LOGGER.info("Enter A for add , D for delete and U for update product");
	    		LOGGER.info(BACK);
	    		while(true) {
	    		String s1 =con.nextLine();
	    		if(s1.equals("A")) {
	    			String id;
	    			String name;
	    			int price;
	    			LOGGER.info("insert its id");
	    			id=con.nextLine();
	    			LOGGER.info("insert its name");
	    			name=con.nextLine();
	    			LOGGER.info("insert its price");
	    			price=Integer.parseInt(con.nextLine());
	    			Product p=new Product(id,name,price);
	    			system.addProduct(p);
	    		}
	    		else if(s1.equals("D")) {
	    			LOGGER.info("insert the id for product to delete it");
	    			String id=con.nextLine();
	    			String pr =system.deleteProduct(id);
	    			LOGGER.info(pr);
	    		}
	    		else if(s1.equals("U")) {
	    			LOGGER.info("insert what you want to update");
	    			String whatUpdate=con.nextLine();
	    			LOGGER.info("insert the id for product");
	    			String id=con.nextLine();
	    			LOGGER.info("insert the new value");
	    			String newValue=con.nextLine();
	    			boolean check =system.updateProduct(newValue, id, whatUpdate);
	    			if(check) {
	    			LOGGER.info("Updated Successfully");}
	    			else {
	    				LOGGER.info("product not valid");}
	    		}
	    		else if (s1.equals("B")) {
	    			list();
	    			break;
	    		}
	    		else {
	    			LOGGER.info(VALID);
	    		}}
	    	}
	    	else if (choice.equals("3")) {
	    		String oId;
	    		String cId;
	    		String pId;
	    		String wId="123";
	    		int numOfOrder;
	    		oId=Integer.toString( system.orders.size());
	    		LOGGER.info("insert id of the customer who has this order");
	    		cId=con.nextLine();
	    		if(! (system.customerValid(cId))) {
	    			LOGGER.info("this customer is not exist! plz enter exist id!");
	    			cId=con.nextLine();
	    		}
	    		LOGGER.info("insert what's the  product he want to clean");
	    		productList();
	    		pId=con.nextLine();
	    		if(!(system.productValid(pId))) {
	    			LOGGER.info("this product is not exist! plz enter exist id!");
    			    pId=con.nextLine();}
	    		LOGGER.info("insert number of products he want");
	    		numOfOrder=Integer.valueOf(con.nextLine());
	    		int wflag=0;
	    		for(int k=0;k<system.workers.size();k++) {
	    			if(system.workers.get(k).getIsFree()) {
	    				wId=system.workers.get(k).id;
	    				system.workers.get(k).setIsFree(false);
	    				wflag=k;
	    				break;
	    			}}
	    		int indexc=0;
	    		int indexp=0;
	    		LOGGER.info("Does he want us to deliver the order? , just write Y for yes  or N for no");
	    		String dflag=con.nextLine();
	    		for(int i=0;i<system.customers.size();i++) {
	    			if(system.customers.get(i).id.equals(cId)) {
	    				indexc=i;
	    				for(int j=0;j<system.products.size();j++) {
	    					if(system.products.get(j).id.equals(pId))
	    						indexp=j;
	    						
	    						
	    				}
	    			}
	    		}
	    		int deliveryPrice=system.diliveryPriceCalc(system.customers.get(indexc));
	    		
				int productPrice=system.productPriceCalc(system.customers.get(indexc),system.products.get(indexp), numOfOrder);
				
				if (dflag.equals("N")) {
					deliveryPrice=0;
				}
				

	    		Order o=new Order(oId,cId,pId,wId,numOfOrder,deliveryPrice,productPrice);
	    		o.setStatus(Status.INTREATMENT);
	    		
	    		int invoice=deliveryPrice+productPrice;
	    		header = String.format("His invoice is: %d", invoice);
	    		LOGGER.info(header);
	    		
	    		LOGGER.info("Status for order now is in treatment,when worker finish insert C for complete ");
	    		while(true) {
	    		String stat=con.nextLine();
	    		if(stat.equals("C")) {
	    			o.setStatus(Status.COMPLETE);
	    			system.orders.add(o);
	    			system.customers.get(indexc).numOfReq+=1;
	    			system.workers.get(wflag).setIsFree(true);
	    			LOGGER.info("order complete ...");
	    			break;
	    		}
	    		else  {
	    			LOGGER.info(VALID);
	
	    		}
	    		}
	    		

	    	}
	    	else if(choice.equals("4")) {
	    		system.report();

	    	}
	    	else if(choice.equals("5")) {
	    		LOGGER.info("Insert C fot total cash ,P for total paid and Dfor delivered items") ; 
	    		LOGGER.info(BACK);
	    		while(true) {
	    			String s2=con.nextLine();
	    		    if(s2.equals("C")) {
	    		        int c = system.totalCash();
	    		        header = String.format("Total cash = %d",c);
	    		        LOGGER.info(header);
	    		    }
	    		    else if(s2.equals("P")) {
	    		        int p = system.totalPaid();
	    		        header = String.format("Total paid = %d", p);	    		        	
	    		        LOGGER.info(header);
	    		    }
	    		    else if(s2.equals("D")){
	    		        int d = system.totaldelivery();
	    		        header = String.format("Total delivered item = %d",d);
	    		        LOGGER.info("Total delivered item =");
	    		    }
	    		    else if(s2.equals("B")) {
	    		        list();
	    		        break;
	    		    }
	    		    else {
	    		        LOGGER.info(VALID);
	    		    }
	    					
	    		}
	    		
	    	}
	    	else if(choice.equals("6")) {
	    		LOGGER.info("Logout successfully");
	    		admin.logOut();
	    		break;
	    	}
	    	else {
	    		LOGGER.info(VALID);
	    	}
	    	}
	   
	    	
	    }
		
		
		
		

	}

}

