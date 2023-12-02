package system;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class user {
	boolean logState;
	private 	String username;
	private String pass;
	private String email;
	private String phone;
	private String role;
    private List<order> orderHistory; 

	public user() {
		username ="jomanahamayel@gmail.com";
		pass="123456";
	}
	 
    public enum Action {
       ADD,EDIT, DELETE, UPDATE_PERMISSIONS
    }
	public user (String username ,String pass,String email,String phone,String role) {
		this.username=username;
		this.pass=pass;
		this.email=email;
		this.phone=phone;
		this.role = role;
		 this.orderHistory = new ArrayList<>();
    
	}
	  
    public void addToOrderHistory(order order) {
        orderHistory.add(order);
    }

    
    public List<order> viewOrderHistory() {
        return orderHistory;
    }
	public void setLoginState(boolean b) {
		logState=b;	
	}
	public boolean getLoginState() {
		return logState;
		}
	public boolean login(String username,String pass) {
		if(logState) {
			
			return false;
			}
		else {
			if(username.equals("jomanahamayel@gmail.com") && pass.equals("123456")) {
				logState=true;
				return true;}
			else {
				return false;
					}
			}
		}
	public void logOut() {
		
		if(logState) {
			logState=false;
		}
		
		
	}
	
	 public void editProfile(String newEmail, String newPassword) {
	        email = newEmail;
	        pass = newPassword;
	    }

	    
	    public String getRole() {
	        return role;
	    }

	    
	    public String getUsername() {
	        return username;
	    }
	

	

	    
	    public void manageUserAccount(user user, Action action) {
	        
	        if (this.role.equals("Admin")) {
	           
	        } else {
	           
	        }
	    }
		public int getId() {
			
			return this.getId();
		}
		public String getName() {
			
			return this.getName();
		}
		public void setName(String name) {
			this.username= name;
		}
		public String getEmail() {
			
			return this.email;
		}
		public void setEmail(String email2) {
			
			this.email=email2;
		}

		
		public void sendEmail(String recipientEmail, String subject, String message) throws MessagingException {
		    
		    String host = "jomanahamayel@gmail.com";
		    String username = "jomanaahamayel";
		    String password = "123456";

		  
		    Properties properties = new Properties();
		    properties.put("mail.smtp.auth", "true");
		    properties.put("mail.smtp.starttls.enable", "true");
		    properties.put("mail.smtp.host", host);
		    properties.put("mail.smtp.port", "587");

		    
		    Session session = Session.getInstance(properties);

		    try {
		      
		        MimeMessage mimeMessage = new MimeMessage(session);

		    
		        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

		     
		        mimeMessage.setSubject(subject);
		        mimeMessage.setText(message);

		       
		        Transport.send(mimeMessage);

		        System.out.println("Email has been successfully sent to " + recipientEmail);
		    } catch (MessagingException e) {
		       
		        e.printStackTrace();
		        throw e;
		    }
		}
	
		    }
		





