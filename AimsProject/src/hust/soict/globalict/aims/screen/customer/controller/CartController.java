package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

import java.io.IOException;

import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	

	private Cart cart;
	private Store store;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
	
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private TextField filterField = new TextField();

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    
    @FXML 
    public void initialize() {
    	colMediaId.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	if(this.cart != null && cart.getItemsOrdered() != null) {
    		 filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);
             SortedList<Media> sortedData = new SortedList<>(filteredData);
             sortedData.comparatorProperty().bind(tblMedia.comparatorProperty());
             tblMedia.setItems(sortedData);
    	}
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});
    	
    	 filterField.textProperty().addListener((observable, oldValue, newValue) -> updateFilteredData());
         filterCategory.selectedToggleProperty().addListener((observable, oldValue, newValue) -> updateFilteredData());
    	
    	updateTotalCost();
    	
    }
    
    private FilteredList<Media> filteredData;
    
    public CartController(Cart cart) {
		this.cart = cart;
	}
	
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	
	protected void updateTotalCost() {
		float totalCost = 0.0f;
		for (Media media: cart.getItemsOrdered()) {
			totalCost += media.getCost();
		}
		
		costLabel.setText(String.format("%.2f $", totalCost));
	}

    protected void updateButtonBar(Media media) {
		if (media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		}
		else {
			btnRemove.setVisible(true);
			if (media instanceof Book) {
				btnPlay.setVisible(false);
			}
			else {
				btnPlay.setVisible(true);
			}
		}
		
	}

	@FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		Media playableMedia = (Media) media;
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Playing Media");
		alert.setHeaderText(null);
		alert.setContentText(playableMedia.play());
		alert.showAndWait();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateTotalCost();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    			fxmlLoader.setController(new ViewStoreController(store, cart));
    			Parent root = fxmlLoader.load();
    			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    			stage.setScene(new Scene(root));
    			stage.setTitle("Store");
    			stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void btnPlaceOrderPressed (ActionEvent event) {
    	if (cart.getItemsOrdered().isEmpty()) {
    		Alert alert = new Alert(Alert.AlertType.WARNING);
    		alert.setTitle("Warning");
    		alert.setHeaderText(null);
    		alert.setContentText("Your cart is empty.");
    		alert.showAndWait();
    	}
    		cart.clearList();;
    		tblMedia.getItems().clear();
    		updateTotalCost();

    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Order Placed");
    		alert.setHeaderText(null);
    		alert.setContentText("Your order has been placed successfully.");
    		alert.showAndWait();
    	}
		
    @FXML
    void updateFilteredData() {
        String filter = filterField.getText().toLowerCase();
        RadioButton selectedRadioButton = (RadioButton) filterCategory.getSelectedToggle();
        String filterType = selectedRadioButton.getText();

		filteredData.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) {
                return true;
            }

            if (filterType.equals("By ID")) {
                return Integer.toString(media.getId()).toLowerCase().contains(filter);
            } else if (filterType.equals("By Title")) {
                return media.getTitle().toLowerCase().contains(filter);
            }
            return false;
        });
    }

}
