package hust.soict.globalict.aims.cart.Cart;

import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media) {
    	this.itemsOrdered.add(media);
    }
    
    public Media findMediaByTitle(String title) {
    	for (Media m:itemsOrdered) {
    		if (m.getTitle().compareTo(title) == 0) {
    			return m;
    		} 
    	}
    	return null;
    }
    
    public void removeMedia(String title) {
    	if (findMediaByTitle(title) != null ) {
    		itemsOrdered.remove(findMediaByTitle(title));
    		System.out.println("Delete Item From Cart Successfully");
    	}
    }
    
    public void filterByTitle(String title) {
    	for (Media m: itemsOrdered) {
    		if (m.getTitle().contains(title)) {
    			System.out.println(m.getId() + " " + m.toString());
    		}
    	}
    }
    
    public void filterById(int id) {
    	for (Media m: itemsOrdered) {
    		if (m.getId() == id) {
    			System.out.println(m.getId() + " " + m.toString());
    		}
    	}
    }
    
    public void sortByTitle() {
    	Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST );
    }
    
    public void sortByCost() {
    	Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE );
    }
    
    public void clearList() {
    	this.itemsOrdered.clear();
    }

//    public void print(){
//    	float totalCost = 0.2f;
//    	System.out.println("******************************CART*********************************");
//    	System.out.println("Ordered Items: ");
//    	int count = 0;
//        for(Media item : this.itemsOrdered){
//        	count = count + 1
//        	totalCost += item.getCost();
//            System.out.println((count) + ". DVD - " + item.getTitle() + " - " +
//            		item.getCategory() + " - " + item.getDirector() + " - "
//            		 + item.getLength() + " : " + 
//            		this.itemsOrdered[i].getCost() + "$");
//        }
//        System.out.println("Total cost: " + totalCost + "$");
//        System.out.println("*******************************************************************");
//    }

    public float totalCost(){
        float sum = 0;
        for(Media media: itemsOrdered){
            sum += media.getCost(); 
        }
        return sum;
    }
    
    public int getLength(){
        return this.itemsOrdered.size();
    }
    
    public void viewCart() {
    	int count = 0;
    	for (Media item:itemsOrdered ) {
    		System.out.println((count + 1) + " " +  item.toString());
    	}
    }
    
//    public void searchDVDsByTitle() {
//    	Scanner scanner = new Scanner(System.in);
//    	
//    	System.out.print("Enter your Title of DVDs you want to find: ");
//    	
//    	String userInput = scanner.nextLine();
//    	
//    	scanner.close();
//    	
//    	int count = 0;
//    	int index = 0;
//    	
//    	for(int i = 0; i < this.qtyOrdered; i++){
//    		if (this.itemsOrdered[i].isMatch(userInput)) {
//    			count = count + 1;
//    		}
//        }
//    	
//    	if (count == 0) {
//    		System.out.println("No DVDs match your keywords");
//    	}
//    	
//    	else {
//    		for(int i = 0; i < this.qtyOrdered; i++){
//        		if (this.itemsOrdered[i].isMatch(userInput)) {
//        			index = index + 1;
//                    System.out.println(index + ". DVD - " + this.itemsOrdered[i].getTitle() + " - " +
//                    		this.itemsOrdered[i].getCategory() + " - " + this.itemsOrdered[i].getDirector() + " - "
//                    		 + this.itemsOrdered[i].getLength() + " : " + 
//                    		this.itemsOrdered[i].getCost() + "$");
//        		}
//            }
//    	}
//    }
}