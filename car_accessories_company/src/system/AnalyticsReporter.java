package system;

import java.util.List;

public class AnalyticsReporter  {


	private install_request[] install_request;

	public void generateProductSalesReport(List<product> products) {
        System.out.println("Product Sales Report:");
        for (product product : products) {
            System.out.println("Product Name: " + product.getname());
            System.out.println("Total Sales: " + calculateTotalSales(product));
            System.out.println("----------------------");
        }
    }

    private double calculateTotalSales(product product) {
        // Calculate total sales for the product (you can customize this based on your data structure and analysis)
        // It is assumed that there is tracking for each purchase order and information about price and quantity
        // This data is analyzed to calculate the total sales for the product
        return 0.0;
    }

    public void generateInstallationReport(List<install_request> installRequests) {
        System.out.println("Installation Report:");
        for (install_request request : install_request) {
        
            System.out.println("Customer Name: " + request.getCustomerName1().getUsername());
            System.out.println("Installation Date: " + request.getInstallationDateTime());
            System.out.println("----------------------");
        }
    }

    // You can add more functions to generate other reports based on business needs
}