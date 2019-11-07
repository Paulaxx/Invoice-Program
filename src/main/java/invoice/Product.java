package invoice;

public class Product {
	
	int price;
	String name;
	
	public Product(int price, String name) {
		this.price=price;
		this.name=name;
	}
	
	public double pricePlusVat(int price) {
		
		double result;
		result=1.23*price;
		return result;
	}
	
	
	

}
