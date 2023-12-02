package system;

import java.util.ArrayList;
import java.util.List;

public class customer extends user {
    public customer (String username ,String pass,String email,String phone,String role) {
       
        super(username, pass, email,phone, "Customer");
    }
    private List<product> productList = new ArrayList<product>();
    public void browseProducts() {
      
        for (product product : productList) {
            System.out.println("prodact_name: " + product.getname());
            System.out.println("price: " + product.getprice());
            System.out.println("Description: " + product.getDescription());
            System.out.println("---------------------");
        }
    }
   
    public void purchaseProduct(product product, int quantity) {
        
        if (product.getStockQuantity() >= quantity) {
            
            int updatedQuantity = product.getStockQuantity() - quantity;
            product.setStockQuantity(updatedQuantity);

            System.out.println("Was purchased " + quantity + "From the product " + product.getname() + " success.");
        } else {
            System.out.println("Quantity not available in stock.");
        }
    }
    public List<order> viewOrderHistory() {
       
        List<order> orderHistory = new ArrayList<order>();
        
        
        return orderHistory;
    }
    public void addReviewAndRating(Review review, product product) {
        product.addReview(review);
    }
}
