package system;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import system.Category;
import system.install_request;

public class Admin extends user {
    public Admin(String username ,String pass,String email,String phone,String role) {
    	
        super(username, pass, email,phone, "Admin");
    }

    private List<product> productList = new ArrayList<product>();
    private List<install_request> installationRequests = new ArrayList<>();
    public void addProduct(product product) {
       
        if (!isproductExist(product)) {
           
            productList.add(product);
            System.out.println("The product has been added successfully");
        } else {
         
            System.out.println("اFor a product that is already in the system.");
        }
    }

    private boolean isproductExist(product product) {
        for (product existingProduct : productList) {
            if (existingProduct.getId() == product.getId()) {
                return true; }
        }
        return false; 
    }

    
    public void editProduct(product product) {
        
        for (int i = 0; i < productList.size(); i++) {
            product existingProduct = productList.get(i);
            if (existingProduct.getId() == product.getId()) {
                existingProduct.setName(product.getname());
                existingProduct.setPrice(product.getprice());
                existingProduct.setDescription(product.getDescription());
                
                System.out.println("I edited the product successfully.");
                return; 
            }
        }
        System.out.println("The desired product was not found.");
    }
    
    public void deleteProduct(product product) {
        
        for (int i = 0; i < productList.size(); i++) {
            product existingProduct = productList.get(i);
            if (existingProduct.getId() == product.getId()) {
                
                productList.remove(i);
                System.out.println("The product has been successfully deleted.");
                return; 
            }
        }
        System.out.println("The desired product was not found.");
    }

    public void addCategory(Category category) {
    	List<Category> categoryList = new ArrayList<Category>();
        categoryList.add(category);
        System.out.println("The category was added successfully");
    }

   
    public void deleteCategory(Category category) {
        List<product> categoryList = null;
		categoryList.remove(category);
        System.out.println("Category deleted successfully.");
    }

  
    
  
     
        private List<user> userList = new ArrayList<user>();

        public void manageUserAccounts(user user, Action action) {
            switch (action) {
                case ADD:
                    
                    userList.add(user);
                    System.out.println("A new user has been added successfully..");
                    break;
                case EDIT:
                   
                    for (user existingUser : userList) {
                        if (existingUser.getId() == user.getId()) {
                            
                            existingUser.setName(user.getName());
                            existingUser.setEmail(user.getEmail());
                           
                            System.out.println("I successfully edited user information.");
                            return;
                        }
                    }
                    System.out.println("The user required for editing was not found.");
                    break;
                case DELETE:
                   
                    for (user existingUser : userList) {
                        if (existingUser.getId() == user.getId()) {
                           
                            userList.remove(existingUser);
                            System.out.println("The user has been deleted successfully.");
                            return;
                        }
                    }
                    System.out.println("The user requested for deletion was not found.");
                    break;
                default:
                    System.out.println("اAn unsupported action.");
                    break;
            }
        }
    
        public void scheduleInstallation(install_request request) {
            LocalDateTime requestedDateTime = request.getInstallationDateTime();

        
            if (isDateTimeAvailable(requestedDateTime)) {
              
                boolean installationSuccessful = performInstallation(request);

                if (installationSuccessful) {
                   
                    request.setStatus("Scheduled");

                
                    notifyInstaller(request);
                    notifyCustomer(request);

                    System.out.println("Installation scheduled successfully.");
                } else {
                    System.out.println("Installation failed. Please try again.");
                }
            } else {
                System.out.println("Requested date and time are not available. Please choose another.");
            }
        }

       

        private boolean performInstallation(install_request request) {
       
            return true;
        }

        private boolean isDateTimeAvailable(LocalDateTime requestedDateTime) {
         
            for (install_request existingRequest : installationRequests) {
                if (existingRequest.getStatus().equals("Scheduled") &&
                    existingRequest.getInstallationDateTime().equals(requestedDateTime)) {
                    return false; 
                }
            }
            return true; 
        }

        private void notifyInstaller(install_request request) {
            
            String installerEmail = "installer@example.com";
            String subject = "Installation Scheduled";
            String message = "Installation for product '" + request.getname() + "' scheduled on "
                    + request.getInstallationDateTime().toString();

            sendEmail(installerEmail, subject, message);
        }

        private void notifyCustomer(install_request request) {
            
            String customerEmail = request.getCustomerEmail();
            String subject = "Installation Scheduled";
            String message = "Installation for product '" + request.getname() + "' scheduled on "
                    + request.getInstallationDateTime().toString();

            sendEmail(customerEmail, subject, message);
        }

        public void sendEmail(String recipientEmail, String subject, String message) {
         
            System.out.println("Sending email to " + recipientEmail + ": " + subject + " - " + message);
        }
        
        public void notifyInstallerAboutInstallationRequest(install_request request) {
            String installerEmail = "installer@example.com";
            String subject = "New Installation Request";
            String message = "New installation request for product '" + request.getname() +
                    "'. Please review and schedule.";

            sendEmail(installerEmail, subject, message);
        }

        public void sendOrderConfirmation(user customer, String orderDetails) {
            String customerEmail = customer.getEmail();
            String subject = "Order Confirmation";
            String message = "Thank you for your order. Order details: " + orderDetails;

            sendEmail(customerEmail, subject, message);
        }
        
        
    }





