package system;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.net.ssl.SSLSession;


public class install extends user {
	    public install(String username ,String pass,String email,String phone,String role)  {
	        
	        super(username, pass, email,phone,"Installer");
	    }

	   
	    public List<install_request> viewInstallationRequests() {
	        List<install_request> installationRequests = new ArrayList<install_request>();
	        
	       
	       
	        return installationRequests;
	    }


	    public void scheduleInstallation(install_request request, LocalDateTime installationDateTime) {
	    
	        request.setInstallationDateTime(installationDateTime);

	        notifyCustomer(request, installationDateTime);

	        performInstallation(request);

	        request.setStatus("Completed");
	    }

	    private void performInstallation(install_request request) {
	      
	        String product = request.getname();
	        String customerName = request.getCustomerName();

	      
	        request.setStatus("Completed");
	    }

	    private void notifyCustomer(install_request request, LocalDateTime installationDateTime) {
	      
	        String customerEmail = request.getCustomerEmail();
	        String subject = "Product installation date";
	        String message = "The product will be installed one day" + installationDateTime.toString();

	        sendEmail(customerEmail, subject, message);

	       
	    }


		public void sendEmail(String customerEmail, String subject, String message) {

            System.out.println("Sending email to " + customerEmail + ": " + subject + " - " + message);
        
        
		}



}

