package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store.*;

public class StoreTest {
	public static void main (String[] args) {
		// Create a new card
		Store store = new Store();
		
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 
				"Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 
				"George Lucas", 87, 24.95f);
		store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 
				 24.95f);
		store.addDVD(dvd3);
		
		// Test the print method
		store.viewStore();
		store.removeDVD(dvd3);
		System.out.println("The Store after removing");
		store.viewStore();
	}
}
