package system;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class install_request {

	
	    private int requestId;
	    private String carMakeModel;
	    private String preferredDate;
	    private user customer;
		private LocalDateTime InstallationDateTime;
		private String Status;

	    public install_request (int requestId, String carMakeModel, String preferredDate, user customer) {
	        this.requestId = requestId;
	        this.carMakeModel = carMakeModel;
	        this.preferredDate = preferredDate;
	        this.customer = customer;
	    }

		public void setInstallationDateTime(LocalDateTime installationDateTime) {
			this.InstallationDateTime =installationDateTime;
			
		}

		public void setStatus(String string) {
			this. Status= string ;
			
		}

		public String getCustomerName() {
			
			return this.getCustomerName();
		}

		public String getname() {
			
			return this .getname();
		}

		public String getCustomerEmail() {
			
			return this.getCustomerEmail();
		}
		

		public LocalDateTime getInstallationDateTime() {
			
			return this.getInstallationDateTime();
		}

		public String getStatus() {
			
			return this.getStatus();
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


		    public user getCustomerName1() {
		        
		        return customer;
		    }

		
	}

