package hust.soict.globalict.aims.Aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart.*;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    public static void main(String[] args) {
    	Store store = new Store();
    	Scanner scanner = new Scanner(System.in);
    	Cart cart = new Cart();
    	int choice, choice_2, choice_3;
    	
    	do {
    		showMenu();
    		choice = scanner.nextInt();
    		scanner.nextLine();
    		
    		switch(choice) {
	    		case 1:
	                store.viewStore();
	                do {
	                	storeMenu();
	 	                choice_2 = scanner.nextInt();
	 	        		scanner.nextLine();
		        		switch (choice_2) {
		                 case 1:
		                	 System.out.println("Enter the title of the media you want to view");
		                     String title = scanner.nextLine();
		                     if (store.returnMediaDetails(title) != null ) {
		                    	store.viewMediaDetails(title);		                     
		                    	do {
				                     mediaDetailsMenu();
				                     choice_3 = scanner.nextInt();
				 	        		 scanner.nextLine();
				 	        		 switch (choice_3) {
					                    case 1:
					                    	System.out.println("Enter the title of the media you want to add to cart");
						                    String title_2 = scanner.nextLine();
						                    if (store.returnMediaDetails(title_2) != null) {
						                    	cart.addMedia(store.returnMediaDetails(title));
						                    	System.out.println(cart.getLength());
						                    }
						                    else {
						                    	System.out.println("The Media is not exist!");
						                    }
					                        break;
					                    case 2:
					                    	System.out.println("Enter the title of the media you want to play");
						                    String title_3 = scanner.nextLine();
						                    DigitalVideoDisc disc1;
						                    CompactDisc disc2;
						                    Book book;
						                    if (store.returnMediaDetails(title_3) != null) {
						                    	if (store.returnMediaDetails(title_3) instanceof DigitalVideoDisc) {
						                    		disc1 = (DigitalVideoDisc) store.returnMediaDetails(title_3); 
						                    		disc1.play();
						                    	}
						                    		
						                    	else if (store.returnMediaDetails(title_3) instanceof CompactDisc) {
						                    		disc2 = (CompactDisc) store.returnMediaDetails(title_3); 
							                    	disc2.play();
						                    	}
						                    	
							                    else if (store.returnMediaDetails(title_3) instanceof Book) {
							                    	book = (Book) store.returnMediaDetails(title_3); 
								                    book.play();
							                    }
						                    		
						                    }
						                    else {
						                    	System.out.println("The Media does not exist!");
						                    }
						                    break;
					                    case 0:
					                        System.out.println("Exiting...");
					                        break;
					                    default:
					                        System.out.println("Invalid choice. Please choose again.");
					                        break;
				 	        		 }
			                     } while(choice_3 != 0);
		                     }
		                     else {
		                    	 System.out.println("The Media is not exist!");
		                     }
		                     break;
		                 case 2:
		                	 System.out.println("Enter the title of the media you want to add to cart");
			                    String title_2 = scanner.nextLine();
			                    if (store.returnMediaDetails(title_2) != null) {
			                    	cart.addMedia(store.returnMediaDetails(title_2));
			                    	System.out.println(cart.getLength());
			                    }
			                    else {
			                    	System.out.println("The Media is not exist!");
			                    }
		                     break;
		                 case 3:
		                	 System.out.println("Enter the title of the media you want to play");
		                     String title_3 = scanner.nextLine();
		                     DigitalVideoDisc disc1;
		                     CompactDisc disc2;
		                     Book book;
		                    if (store.returnMediaDetails(title_3) != null) {
		                    	if (store.returnMediaDetails(title_3) instanceof DigitalVideoDisc) {
		                    		disc1 = (DigitalVideoDisc) store.returnMediaDetails(title_3); 
		                    		disc1.play();
		                    	}
		                    		
		                    	else if (store.returnMediaDetails(title_3) instanceof CompactDisc) {
		                    		disc2 = (CompactDisc) store.returnMediaDetails(title_3); 
			                    	disc2.play();
		                    	}
		                    	
			                    else if (store.returnMediaDetails(title_3) instanceof Book) {
			                    	book = (Book) store.returnMediaDetails(title_3); 
				                    book.play();
			                    }
		                    		
		                     }
		                     else {
		                     	System.out.println("The Media is not exist!");
		                     }
		                     break;
		                 case 4:
		 	            	do {
		 	            		cartMenu();
		 		        		choice_2 = scanner.nextInt();
		 		        		scanner.nextLine();
		 		        		
		 		        		switch(choice_2) {
		 			        			case 1:
		 			        				do {
		 			        					filterMenu();
		 			        					choice_3 = scanner.nextInt();
		 			        					scanner.nextLine();
		 			        					switch (choice_3) {
		 			        						case 1: 
		 			        							System.out.println("Enter the title of the media you want to filter: ");
		 			        							String title_4 = scanner.nextLine();
		 			        							cart.filterByTitle(title_4);
		 			        							break;
		 			        						case 0:
		 			        							System.out.println("Exiting...");
		 			        						default:
		 			        							System.out.println("Invalid Option");
		 			        					}
		 			        				} while (choice_3 != 0);
		 			        				break;
		 			        			case 2:
		 			        				do {
		 			        					sortMenu();
		 			        					choice_3 = scanner.nextInt();
		 			        					scanner.nextLine();
		 			        					switch (choice_3) {
		 		        						case 1: 
		 		        							cart.sortByCost();
		 		        							System.out.println("Sort By Cost Successfully! ");
		 		        							System.out.println("The array after sorting is: ");
		 		        							cart.viewCart();
		 		        							break;
		 		        						case 2:
		 		        							cart.sortByTitle();
		 		        							System.out.println("Sort By Title Successfully! ");
		 		        							System.out.println("The array after sorting is: ");
		 		        							cart.viewCart();
		 		        							break;
		 		        						case 0:
		 		        							System.out.println("Exiting...");
		 		        						default:
		 		        							System.out.println("Invalid Option");
		 		        					}
		 		        				} while(choice_3 != 0);
		 			        			break;
		 			        				
		 			        			case 3: 
		 			        				System.out.println("Enter the title of the media you want to remove: ");
			        						String title_4 = scanner.nextLine();
			        						cart.removeMedia(title_4);
		 			        				break;
		 			        				
		 			        			case 4: 
		 			        				System.out.println("Enter the title of the media you want to play");
						                    String title_5 = scanner.nextLine();
						                    DigitalVideoDisc disc3;
						                    CompactDisc disc4;
						                    Book book1;
						                    if (store.returnMediaDetails(title_5) != null) {
						                    	if (store.returnMediaDetails(title_5) instanceof DigitalVideoDisc) {
						                    		disc3 = (DigitalVideoDisc) store.returnMediaDetails(title_5); 
						                    		disc3.play();
						                    	}
						                    		
						                    	else if (store.returnMediaDetails(title_5) instanceof CompactDisc) {
						                    		disc4 = (CompactDisc) store.returnMediaDetails(title_5); 
							                    	disc4.play();
						                    	}
						                    	
							                    else if (store.returnMediaDetails(title_5) instanceof Book) {
							                    	book1 = (Book) store.returnMediaDetails(title_5); 
								                    book1.play();
							                    }
						                    		
						                    }
						                    else {
						                    	System.out.println("The Media is not exist!");
						                    }
		 			        				break;
		 			        			case 5: 
		 			        				System.out.println("The order is made successfully");
		 			        				cart.clearList();
		 			        				cart.viewCart();
		 			        				break;
		 			        				
		 			        			case 0:
		 			        				System.out.println("Exiting...");
		 			        				break;
		 			        			default: 
		 			        				System.out.println("Invalid Option !");
		 			        				break;
		 		        		}
		 	            	} while(choice_2 != 0);
		 	            	break;
		                 case 0:
		                     System.out.println("Exiting...");
		                     break;
		                 default:
		                     System.out.println("Invalid choice. Please choose again.");
		                     break;
		        		}
	                } while(choice_2 != 0);
	                break;
	            case 2:
	            	System.out.println("Enter the type of media you want to add to Store (DVD, CD, Book): ");
	                String type = scanner.nextLine();
	                
	                if (type.compareTo("DVD") == 0) {
	                	System.out.println("Enter the title of the DVD: ");
	                	String title = scanner.nextLine();
	                	System.out.println("Enter the category of the DVD: ");
	                	String category = scanner.nextLine();
	                	System.out.println("Enter the director of the DVD: ");
	                	String director = scanner.nextLine();
	                	System.out.println("Enter the length of the DVD: ");
	                	int length = scanner.nextInt();
	                	System.out.println("Enter the cost of the DVD: ");
	                	float cost = scanner.nextFloat();
	                	DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
	                	store.addDVD(dvd);
	                }
	                if (type.compareTo("CD") == 0) {
	                	System.out.println("Enter the title of the CD: ");
	                	String title = scanner.nextLine();
	                	System.out.println("Enter the category of the CD: ");
	                	String category = scanner.nextLine();
	                	System.out.println("Enter the cost of the CD: ");
	                	float cost = scanner.nextFloat();
	                	CompactDisc cd = new CompactDisc(title, category, cost);
	                	store.addDVD(cd);
	                }
	                if (type.compareTo("Book") == 0) {
	                	System.out.println("Enter the title of the DVD: ");
	                	String title = scanner.nextLine();
	                	System.out.println("Enter the category of the DVD: ");
	                	String category = scanner.nextLine();
	                	System.out.println("Enter the cost of the DVD: ");
	                	float cost = scanner.nextFloat();
	                	Book book = new Book(title, category, cost);
	                	store.addDVD(book);
	                }
	                break;
	            case 3:
	                break;
	            case 0:
	                System.out.println("Exiting...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please choose again.");
	                break;
    		}
    	} while (choice != 0);
    	scanner.close();
    	System.out.println("Thank you for using our service");
    }
    
    // Home interface
    public static void showMenu() {
    	System.out.println("AIMS: ");
    	System.out.println("-----------------------");
    	System.out.println("1. View store");
    	System.out.println("2. Update store");
    	System.out.println("3. See current cart");
    	System.out.println("0. Exit");
    	System.out.println("-----------------------");
    	System.out.println("Please choose a number: 0-1-2-3");	
    }
    
    // View store
    public static void storeMenu() {
    	System.out.println("Options");
    	System.out.println("-----------------------");
    	System.out.println("1. See a media's details");
    	System.out.println("2. Add a media to cart");
    	System.out.println("3. Play a media");
    	System.out.println("4. See current cart");
    	System.out.println("0. Back");
    	System.out.println("-----------------------");
    	System.out.println("Please choose a number: 0-1-2-3-4");
    }
    
    // Media details
    public static void mediaDetailsMenu() {
    	System.out.println("Options ");
    	System.out.println("-----------------------");
    	System.out.println("1. Add to cart");
    	System.out.println("2. Play");
    	System.out.println("0. Back");
    	System.out.println("-----------------------");
    	System.out.println("Please choose a number: 0-1-2");	
    }
    
    // View current cart
    public static void cartMenu() {
    	System.out.println("Options");
    	System.out.println("-----------------------");
    	System.out.println("1. Filter media in cart");
    	System.out.println("2. Sort media in cart");
    	System.out.println("3. Remove media from cart");
    	System.out.println("4. Play a media");
    	System.out.println("5. Place order");
    	System.out.println("0. Back");
    	System.out.println("-----------------------");
    	System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    
    // Filter media option
    public static void filterMenu() {
    	System.out.println("Options");
    	System.out.println("-----------------------");
    	System.out.println("1. Filter by Title");
    	System.out.println("2. Filter by Id");
    	System.out.println("0. Back");
    	System.out.println("-----------------------");
    	System.out.println("Please choose a number: 0-1-2");
    }
    
    // Sort media option
    public static void sortMenu() {
    	System.out.println("Options");
    	System.out.println("-----------------------");
    	System.out.println("1. Sort by Title");
    	System.out.println("2. Sort by Cost");
    	System.out.println("0. Back");
    	System.out.println("-----------------------");
    	System.out.println("Please choose a number: 0-1-2");
    }
    
}
