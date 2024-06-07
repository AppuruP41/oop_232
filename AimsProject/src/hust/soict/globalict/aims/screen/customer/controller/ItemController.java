package hust.soict.globalict.aims.screen.customer.controller;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	
	private Media media;
	private Cart cart;
	
	public ItemController(Cart cart) {
		this.cart = cart;
	}
	
	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost() + "$");
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
		}
	}

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
		if ( cart.getItemsOrdered().size() < cart.getMAX_NUMBER_ORDERED() ) {
			cart.addMedia(media);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Item Added");
			alert.setHeaderText(null);
			alert.setContentText(media.getTitle() + " has been added to your cart.");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Warning");
			alert.setHeaderText(null);
			alert.setContentText("Only " + cart.getMAX_NUMBER_ORDERED() + " items can be added to your cart.");
			alert.showAndWait();
		}

    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Playing Media");
		alert.setHeaderText(null);
    	
    	if (media instanceof Book) {
    		alert.setAlertType(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("This media cannot be played.");
			alert.showAndWait();
		} else {
			Media playableMedia = (Media) media;
			try {
		        alert.setContentText(playableMedia.play());
			} catch (PlayerException e) {
				 	alert.setAlertType(Alert.AlertType.ERROR);
				 	System.out.println("Exception: " + e.getMessage());
		            System.out.println(e.toString());
		            e.printStackTrace();

		            JOptionPane.showMessageDialog(null,
		                    "Exception occurred: " + e.getMessage() + "\n" + e.toString(),
		                    "PlayerException",
		                    JOptionPane.ERROR_MESSAGE);
		            return;
			}
			alert.showAndWait();

		}
           
    }

}

