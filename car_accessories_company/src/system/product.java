package system;

import java.util.ArrayList;
import java.util.List;

public class product {
    private int productId;
    private String name;
    private double price;
    private String description;
    private String category;
	private int StockQuantity;

    public product(int productId, String name, double price, String description, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return this.productId; 
    }
	public String getname() {
		
		return this.name;
	}

	public double getprice() {
		
		return this.price;
	}

	public String getDescription() {
		
		return this.description;
	}

	public void setName(String getname) {
	    
	    this.name = getname;
	}

	public void setPrice(double getprice) {

	    this.price = getprice;
	}
	public void setDescription(String  description2) {
	
		this.description = description2;
	}

	public int getStockQuantity() {
		
		return this.getStockQuantity();
	}

	public void setStockQuantity(int updatedQuantity) {
		this.StockQuantity = updatedQuantity;
		
	}
	
	
	 private List<Review> reviews = new ArrayList<>();

	    public void addReview(Review review) {
	        reviews.add(review);
	    }

	    public double getAverageRating() {
	        if (reviews.isEmpty()) {
	            return 0;
	        }

	        double totalRating = 0;
	        for (Review review : reviews) {
	            totalRating += review.getRating();
	        }

	        return totalRating / reviews.size();
	    }

	    public List<Review> getReviews() {
	        return reviews;
	    }
	}

