package hust.soict.globalict.aims.Aims;

import hust.soict.globalict.aims.screen.manager.AddBookToStoreScreen;
import hust.soict.globalict.aims.screen.manager.AddItemToStoreScreen;
import hust.soict.globalict.aims.screen.manager.StoreManagerScreen;
import hust.soict.globalict.aims.store.Store;

public class AimsGUI {
	private static Store store = new Store();
	public static void main(String[] args) {
       StoreManagerScreen newStore = new StoreManagerScreen(store);
//        AddItemToStoreScreen myScreen = new AddItemToStoreScreen();
//        AddBookToStoreScreen myScreen = new  AddBookToStoreScreen();
	}
}
