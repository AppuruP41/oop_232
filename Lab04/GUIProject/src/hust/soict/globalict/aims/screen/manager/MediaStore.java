package hust.soict.globalict.aims.screen.manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private CompactDisc cd; 
	private DigitalVideoDisc dvd;
	public MediaStore(Media media) {
		this.media = media;
		if (media instanceof CompactDisc) {
			cd = (CompactDisc) media; 
		}
		if (media instanceof DigitalVideoDisc) {
			dvd = (DigitalVideoDisc) media;
		}
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setLayout(new FlowLayout(FlowLayout.CENTER));
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if (media instanceof CompactDisc || media instanceof DigitalVideoDisc) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(container), "Confirm Play", true);
					
					JLabel label = new JLabel("Are you sure want to play " + media.getTitle() + " ?");
					JButton yesButton = new JButton("Yes");
					JButton noButton = new JButton("No");
					yesButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    dialog.dispose();
		                    if (cd != null) {
		                    	JOptionPane.showMessageDialog(container, cd.play() , "Now Playing", JOptionPane.INFORMATION_MESSAGE);
		                    }
		                    else {
		                    	JOptionPane.showMessageDialog(container, dvd.play(), "Now Playing", JOptionPane.INFORMATION_MESSAGE);
		                    }
		                    
		                }
		            });
		            
		            noButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    dialog.dispose();
		                }
		            });
		            
		            JPanel panel = new JPanel();
		            panel.add(label);
		            panel.add(yesButton);
		            panel.add(noButton);
		            
		            dialog.add(panel);
		            dialog.pack();
		            
		            dialog.setLocationRelativeTo(null);
		            dialog.setVisible(true);
		            
				}
			});
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
}
