package Aim;

public class Aims {
   public static void main(String[] args) {
	   Cart makeOrder = new Cart();
	   DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Anmation", "Roger Allers", 87, 19.95f);
	   makeOrder.addDigitalVideoDisc(dvd1);
	   DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
	   makeOrder.addDigitalVideoDisc(dvd2);
	   DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f );
	   makeOrder.addDigitalVideoDisc(dvd3);
	   
	   makeOrder.removeDigitalVideoDisc(dvd2);
	   System.out.println("The total cost is: "+ makeOrder.totalCost());
			
   }
}