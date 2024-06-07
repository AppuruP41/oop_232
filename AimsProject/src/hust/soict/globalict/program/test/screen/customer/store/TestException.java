package hust.soict.globalict.program.test.screen.customer.store;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TestException extends Application {
    private static Store store;
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String[] args) throws PlayerException {
        store = new Store();
        Media book1 = new Book(1, "Effective Java", "Programming", 45.0f);
        ((Book) book1).addAuthor("Joshua Bloch");

        Media book2 = new Book(2, "Clean Code", "Programming", 42.0f);
        ((Book) book2).addAuthor("Robert C. Martin");

        Media book3 = new Book(3, "The Pragmatic Programmer", "Programming", 40.0f);
        ((Book) book3).addAuthor("Andrew Hunt");
        ((Book) book3).addAuthor("David Thomas");

        Media book4 = new Book(3, " Programmer", "Programming", 40.0f);
        ((Book) book3).addAuthor("Andrew Hunt");
        ((Book) book3).addAuthor("David Thomas");

        Media cd1 = new CompactDisc(4, "Abbey Road", "Music", "George Martin", "The Beatles", 47, 20.0f);
        ((CompactDisc) cd1).addTrack(new Track("Come Together", 259));
        ((CompactDisc) cd1).addTrack(new Track("Something", 183));
        ((CompactDisc) cd1).addTrack(new Track("Maxwell's Silver Hammer", 207));
        ((CompactDisc) cd1).addTrack(new Track("Oh! Darling", 207));
        ((CompactDisc) cd1).addTrack(new Track("Octopus's Garden", 175));

        Media cd2 = new CompactDisc(5, "Thriller", "Pop", "Quincy Jones", "Michael Jackson", 42, 25.0f);
        ((CompactDisc) cd2).addTrack(new Track("Wanna Be Startin' Somethin'", 362));
        ((CompactDisc) cd2).addTrack(new Track("Baby Be Mine", 0));
        ((CompactDisc) cd2).addTrack(new Track("The Girl Is Mine", 228));
        ((CompactDisc) cd2).addTrack(new Track("Thriller", 357));
        ((CompactDisc) cd2).addTrack(new Track(" Yeah", 258));

        Media cd3 = new CompactDisc(6, "Dark Side of the Moon", "Rock", "Pink Floyd", "Pink Floyd", 43, 22.0f);
        ((CompactDisc) cd3).addTrack(new Track("Speak to Me", 90));
        ((CompactDisc) cd3).addTrack(new Track("Breathe", 163));
        ((CompactDisc) cd3).addTrack(new Track("On the Run", 216));
        ((CompactDisc) cd3).addTrack(new Track("Time", 407));
        ((CompactDisc) cd3).addTrack(new Track("The Great Gig in the Sky", 276));

//        Error input Track title == "" in PlayerException: :Title cannot be empty / length must be > 0
//        Media cd4 = new CompactDisc(6, "Dark Side of the Moon", "Rock", "Pink Floyd", "Pink Floyd", 43, 22.0f);
//        ((CompactDisc) cd3).addTrack(new Track("Speak to Me", 90));
//        ((CompactDisc) cd3).addTrack(new Track("Breathe", 163));
//        ((CompactDisc) cd3).addTrack(new Track("On the Run", 216));
//        ((CompactDisc) cd3).addTrack(new Track("Time", 407));
//        ((CompactDisc) cd3).addTrack(new Track("", 276));

        Media dvd1 = new DigitalVideoDisc(7, "The Godfather", "Crime", "Francis Ford Coppola", 175, 30.0f);

        Media dvd2 = new DigitalVideoDisc(8, "The Shawshank Redemption", "Drama", "Frank Darabont", 0, 25.0f);

        Media dvd3 = new DigitalVideoDisc(9, "Inception", "Science Fiction", "Christopher Nolan", 148, 28.0f);

        store.addDVD(book1);
        store.addDVD(book2);
        store.addDVD(book3);
        store.addDVD(cd1);
        store.addDVD(cd2);
        store.addDVD(cd3);
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(book4);
        launch(args);
    }
}
