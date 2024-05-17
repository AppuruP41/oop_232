package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {
	protected Store store = new Store();
	
	public AddItemToStoreScreen(Store store) {
		this.store = store;
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
		
		JLabel title = new JLabel("Adding Media");
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
		return center;
	}
	
	private class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e);
		}
	}
}
