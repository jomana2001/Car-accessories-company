package system;

import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MySystem {
    private static final Logger LOGGER = Logger.getLogger(MySystem.class.getName());
    static final String ADDRESS="Address";
	 LinkedList<Customer> customers =new LinkedList<Customer>();
	 LinkedList<Product> products=new LinkedList<Product>();
	 LinkedList<Worker> workers=new LinkedList<Worker>();
	 LinkedList<Order> orders=new LinkedList<Order>();	
	public MySystem() {
		workers.add(new Worker("123","hamza ahmad","0598937949","Rafedia",true));
		workers.add(new Worker("113","taher yaseen","0599894568","Rafedia",true));
		workers.add(new Worker("223","ayman mohammed","059378568","makhfia",true));
		
		customers.add(new Customer("123456","faihaa odeh","s11923877@stu.najah.edu",5,"0599773638","DerAlhatab"));
		customers.add(new Customer("113456","lana jaber","faihaa.odeh20@gmail.com",2,"0595721772","rafidia"));
		customers.add(new Customer("987654","jana taher","s11819423@stu.najah.edu",1,"0593020265","makhfia"));
		
		
		products.add(new Product("0","CARPET minimum than 9",15));
		products.add(new Product("1","CARPET greater than 9 and smaller than 16",20));
		products.add(new Product("2","CARPET greater than 16",30));
		products.add(new Product("3","SINGLECOVER",13));
		products.add(new Product("4","COUPLECOVER",20));
		products.add(new Product("5","CURTAIN",8));
		
	}
	public boolean report() {
		int i;
		LOGGER.info("These customers are registered in the system");
		String header = String.format("%-20s|%-20s|%-25s|%-20s|%-10s|%-20s|%n","Id","Name","email","Number of request","Phone",ADDRESS);
		LOGGER.info(header);
		for ( i=0;i<customers.size();i++) {	                
			 header = String.format("%-20s|%-20s|%-25s|%-20d|%-10s|%-20s|%n",customers.get(i).id,customers.get(i).name,customers.get(i).email,customers.get(i).numOfReq,customers.get(i).phone,customers.get(i).address);
			 LOGGER.info(header);
		}
		i=0;
		LOGGER.info("_____________________________________________________________________________________________________________"+"\n");
		LOGGER.info("These products are valid in the system");
		header = String.format("%-10s|%-42s|%-10s|%n","Id","Name","price");
		LOGGER.info(header);
		for (i=0;i<products.size();i++) {
			header = String.format("%-10s|%-42s|%-10d|%n",products.get(i).id,products.get(i).name,products.get(i).price);	
			LOGGER.info(header);
		}
		
		i=0;
		LOGGER.info("_____________________________________________________________________________________________________________"+"\n");
		LOGGER.info("These workers works in the system");
		header = String.format("%-10s|%-20s|%-11s|%-15s|%n","Id","Name","Phone",ADDRESS);
		LOGGER.info(header);
		for(i=0;i<workers.size();i++) {	                 
			header = String.format("%-10s|%-20s|%-11s|%-15s|%n",workers.get(i).id,workers.get(i).name,workers.get(i).phone,workers.get(i).address);	    			
			LOGGER.info(header);
		}
		return true;
	}
	
	public int totalCash() {
		int cash=0;
		for(int i=0;i<orders.size();i++) {
			cash+=orders.get(i).productPrice;
		}
		return cash;
	}
	public int totaldelivery() {
		int delivery=0;
		for(int i=0;i<orders.size();i++) {
			if(orders.get(i).deliveryPrice != 0)
				delivery+=1;
		}
		return delivery;
	}
	public int totalPaid() {
		int size=orders.size()+1;
		return 5*size;
	}
	public boolean register(Customer c) {
			for(int i=0;i<customers.size();i++) {
				if(c.id.equals(customers.get(i).id)) {
					return false;
				}
			}
			customers.add(c);
			return true;
		
	}
	public boolean update(String w, String iD,String n) {
		String whatUpdate =w;
		String newValue =n;
		String id=iD;
			for(int i=0;i<customers.size();i++) {
				if(id.equals(customers.get(i).id)) {
					if(whatUpdate.equals("address")) 
						customers.get(i).setAddress(newValue);
					else if(whatUpdate.equals("name"))
						customers.get(i).setName(newValue);
					else if (whatUpdate.equals("username"))
						customers.get(i).setUserName(newValue);
					else if(whatUpdate.equals("phone"))
						customers.get(i).setPhone(newValue);
					else if(whatUpdate.equals("numOfReq"))
						customers.get(i).setNumOfReq(Integer.parseInt(newValue));
					return true;
				}
			}
			return false;
		
		
	}
	public boolean addProduct(Product p) {
			
				for(int i=0;i<products.size();i++) {
					if(p.id.equals(products.get(i).id)) {
						return false;
					}
				}
				products.add(p);
				return true;	
	}
	public String deleteCustomer(String iD) {
		int index=-1;
			for(int i=0;i<customers.size();i++) {
				if(iD.equals(customers.get(i).id)) {
					index=1;
					
				}
				
			}
			
			if(index==-1) {
				return "customer is not registered";
			}
			else {
			customers.remove(index);
			return "customer deleted successfully";}
		
	}
	public String deleteProduct(String iD) {
		int index=-1;
		
			for(int i=0;i<products.size();i++) {
				if(iD.equals(products.get(i).id)) {
					index=i;
				}
				
			}
			if(index==-1) {
				return "product is not valid";
			}
			else {
			products.remove(index);
			return "product deleted successfully";}
		
	}
	public boolean pisupdated(String id) {
		for(int i =0;i<products.size();i++)
			if(id.equals(products.get(i).id))
					return true;
		return false;
			
	}
	public boolean updateProduct(String w, String iD, String n) {
		String id=iD;
		String whatUpdate=w;
		String newValue=n;
		boolean flag=false;
		
			for(int i=0;i<products.size();i++) {
				if(id.equals(products.get(i).id)) {
					if(whatUpdate .equals("name")) {
						products.get(i).setName(newValue);
						
					}
					else if(whatUpdate.equals("price")) {
						products.get(i).setPrice(Integer.valueOf(newValue));
						
					}
					flag=true;
					
				}
				
			}
			return flag;
		
	}
	
	public boolean customerValid(String id) {
		int flag=0;
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).id.equals(id))
				flag =1;
		}
		return (flag == 1);
	}
	public boolean productValid(String id) {
		boolean flag=false;
		for(int i=0;i<products.size();i++) {
			if(products.get(i).id.equals(id))
				flag =true;
		}
		return flag;
	}
public String search(String id) {
			for(int i=0;i<customers.size();i++) {
				if(id.equals(customers.get(i).id)) {
				return "coustomer information => id:"+customers.get(i).id + ", name:"+customers.get(i).name+", email:"+customers.get(i).email+" , number of requests:"+customers.get(i).numOfReq+" , phone number:"+customers.get(i).phone+" , address:"+customers.get(i).address;
				}
			}
			return "customer is not registered";
		
		}
		public String searchProduct(String id) {
			String iD=id;
				for(int i=0;i<products.size();i++) {
					if(iD.equals(products.get(i).id)) {
						return "product information => id:"+products.get(i).id+" , name:"+products.get(i).name+" , price:"+products.get(i).price;
					}
					}
				
				return "product is not valid";
			}
	
	public String distribute( Order o) {
		int index=-1;
		for(int i=0;i<workers.size();i++) {
			if(workers.get(i).getIsFree()) {
				index=i;
				o.wId=workers.get(i).id;
				workers.get(i).setIsFree(false);
				o.setStatus(Status.INTREATMENT);
				break;
			}
		}
		if(index==-1) {
			return "all worker is not available";
		}
		else 
			return "worker"+workers.get(index).id+"received the order";
		
	}
	
	
	public void sendGmail(String email) throws MessagingException {
		String from = "leen.aljaber123@gmail.com";
        String to = email;
        String subject = "Order Complete !";
        String body = "Your order is completed , thank you for dealing with us :)";

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "mail.example.com");

        Session session = Session.getInstance(properties);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
        
	}
	public boolean sendEmail(String email) {
	      String from = "leen.aljaber123@gmail.com";
		  String to = email;
	      String host = "localhost";
	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);
	      Session session = Session.getDefaultInstance(properties);

	      try {

	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         message.setSubject("order complete!");

	         message.setText("Your order is completed , thank you for dealing with us :)");
	         Transport.send(message);
	         
	        
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		 return true;
	   }
	public int diliveryPriceCalc(Customer c ) {
		String s=c.address;
		int deliveryPrice=12;
		if(s.toUpperCase().trim().equals("DERALHATAB"))
			deliveryPrice=20;
		else if(s.toUpperCase().trim().equals("TELSTREET"))
			deliveryPrice=15;
		else if(s.toUpperCase().trim().equals("MREGSTREET"))
			deliveryPrice=15;
		else if(s.toUpperCase().trim().equals("STREER15"))
			deliveryPrice=14;
		else if(s.toUpperCase().trim().equals("ASERA"))
			deliveryPrice=18;
		else if(s.toUpperCase().trim().equals("DERSHARAF"))
			deliveryPrice=18;
		else deliveryPrice=12;
		return deliveryPrice;
	}
	public int productPriceCalc(Customer c,Product p,int numOfOrder) {
		int productPrice;
		if(c.hasDiscount()) {
			productPrice=(p.price)*numOfOrder - ((int)( p.price*0.15));
			
		}
		else {
			productPrice=p.price;
		}
		return productPrice ;
	}

	
}
