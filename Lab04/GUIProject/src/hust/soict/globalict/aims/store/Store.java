package hust.soict.globalict.aims.store;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.*;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addDVD(Media disc) {
		this.itemsInStore.add(disc);
		System.out.println("Add Item to the Store Successfully");
	}
	
	public void removeDVD(Media disc) {
		this.itemsInStore.remove(disc);
	}
	
	public void viewStore() {
		int count = 0;
		for (Media m:itemsInStore) {
			count = count + 1;
			System.out.println(count + m.toString());
		}
	}
	
	public void viewMediaDetails(String title) {
		int count = 0;
		for (Media m:itemsInStore) {
			if (m.isMatch(title) == 0) {
				count = count + 1;
				System.out.println(count + m.toString());
			}
		}
	}
	
	public Media returnMediaDetails(String title) {
		for (Media m:itemsInStore) {
			if (m.isMatch(title) == 0) {
				return m;
			}
		}
		return null;
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
	public int getLength() {
		return this.itemsInStore.size();
	}
}
