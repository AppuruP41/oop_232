package hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField titleInput;
	private JTextField categoryInput;
	private JTextField directorInput;
	private JTextField artistInput;
	private JTextField lengthInput;
	private JTextField costInput;
	private JTextField idInput;
	
	
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitListener());
		cp.add(submitButton, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("Adding CD");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel(new GridLayout(7, 2, 10, 10));
		center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		center.add(new JLabel("Enter the title of the CD you want to add: "));
		titleInput = new JTextField(20);
		center.add(titleInput);
		
		
		center.add(new JLabel("Enter the category of the CD you want to add: "));
		categoryInput = new JTextField(20);
		center.add(categoryInput);
		
		center.add(new JLabel("Enter the director of the CD you want to add: "));
		directorInput = new JTextField(20);
		center.add(directorInput);
		
		center.add(new JLabel("Enter the artist of the CD you want to add: "));
		artistInput = new JTextField(20);
		center.add(artistInput);

		center.add(new JLabel("Enter the cost of the CD you want to add: "));
		costInput = new JTextField(20);
		center.add(costInput);
		
		center.add(new JLabel("Enter the length of the CD you want to add: "));
		lengthInput = new JTextField(20);
		center.add(lengthInput);
		
		center.add(new JLabel("Enter the id of the CD you want to add: "));
		idInput = new JTextField(20);
		center.add(idInput);
		
		return center;
	}
	
	private class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				CompactDisc newCD = new CompactDisc(Integer.parseInt(idInput.getText()), 
						titleInput.getText(), categoryInput.getText(),directorInput.getText(),
						artistInput.getText() ,Integer.parseInt(lengthInput.getText()) 
						,Float.parseFloat(costInput.getText()));
				
				store.addDVD(newCD);
				dispose();
				StoreManagerScreen myScreen = new StoreManagerScreen(store);
				myScreen.setVisible(true);
			} catch(NumberFormatException error) {
				JOptionPane.showMessageDialog(null, "Invalid Input! Please Enter Integer for ID,Length Field , Float for Cost Field", "Warning", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
}
