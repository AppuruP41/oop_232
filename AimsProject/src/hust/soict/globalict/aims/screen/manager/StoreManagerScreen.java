package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class StoreManagerScreen extends JFrame {
	private Store store;
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStoreBtn = new JMenuItem("View store");
		
		viewStoreBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				StoreManagerScreen newStore = new StoreManagerScreen(store);
			}
		});
		
		menu.add(viewStoreBtn);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBookItem = new JMenuItem("Add Book");
		addBookItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddBookToStoreScreen addBookScreen = new  AddBookToStoreScreen(store);
				addBookScreen.setVisible(true);
			}
		});
		smUpdateStore.add(addBookItem);
		JMenuItem addCDItem = new JMenuItem("Add CD");
		addCDItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddCompactDiscToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(store);
				addCDScreen.setVisible(true);
			}
		});
		
		smUpdateStore.add(addCDItem);
		
		JMenuItem addDVDItem = new JMenuItem("Add DVD");
		addDVDItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(store);
				addDVDScreen.setVisible(true);
			}
		});
		smUpdateStore.add(addDVDItem);
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		System.out.println(this.store.getLength());
		if(this.store != null && this.store.getLength() != 0) {
			ArrayList<Media> mediaInStore = store.getItemsInStore();
			for (int i = 0; i < this.store.getLength(); i++) {
				MediaStore cell = new MediaStore(mediaInStore.get(i));
				center.add(cell);
			}
		}
		return center;
	}
}
