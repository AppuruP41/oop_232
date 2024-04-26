package Aim;

public class Cart {
   public static final int MAX_NUMBERS_ORDERED = 20;
   private DigitalVideoDisc itemsOrdered[]=
		   new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
   private int qtyOrdered = 0;
   
   public void addDigitalVideoDisc(DigitalVideoDisc disc ) {
	   if(qtyOrdered<MAX_NUMBERS_ORDERED) {
		   itemsOrdered[qtyOrdered]= disc;
		   qtyOrdered+=1;
		   System.out.println("The disc has been added");	   
	   }
	   else {
		   System.out.println("The cart is full (20 items)");
		   return;
	   }
   }
   
   public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	    if (qtyOrdered <= 0) {
	        System.out.println("There is no item in the cart");
	        return;
	    } else {
	        boolean discFound = false;
	        for (int i = 0; i < qtyOrdered; i++) {
	            if (itemsOrdered[i].equals(disc)) {
	                for (; i < qtyOrdered - 1; i++) {
	                    itemsOrdered[i] = itemsOrdered[i + 1];
	                }
	                qtyOrdered--;
	                discFound = true;
	                System.out.println("The disc has been removed");
	            }
	        }
	        if (!discFound) {
	            System.out.println("Disc not found in the cart");
	        }
	    }
	}
   
   public float totalCost() {
	float sum =0;
	for (int i=0; i<qtyOrdered; i++) {
		sum+=itemsOrdered[i].getCost();}
	return sum;   
   }
   
}
	