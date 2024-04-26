package hust.soict.globalict.test.cart.CartTest;
import hust.soict.globalict.aims.cart.Cart.*;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main (String[] args) {
		// Create a new card
		Cart cart = new Cart();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 
				"Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 
				"George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 
				 24.95f);
		cart.addMedia(dvd3);
		
		// Test the print method
		cart.viewCart();;
		//To-do: Test the search method here
		
	}
}
