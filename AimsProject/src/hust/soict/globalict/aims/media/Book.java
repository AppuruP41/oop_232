package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media implements Playable {
	private List<String> authors = new ArrayList<String>();

	public void addAuthor(String authorName) {
		if (!this.authors.contains(authorName)) {
			this.authors.add(authorName);
		}
		
	}
	
	public void removeAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			this.authors.remove(authorName);
		}
	}
	
	public Book(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

	public Book(int id, String title, String category, float cost) throws PlayerException {
		super();
		if ( id < 0) {
			throw new PlayerException("Invalid ID");
		} else if (title == null) {
			throw new PlayerException("Invalid title");
		} else if (category == null) {
			throw new PlayerException("Invalid category");
		} else if (cost < 0) {
			throw new PlayerException("Invalid cost");
		}
		this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = id;
    }
	
    @Override
    public String toString() {
    	return ". Book - " + this.getTitle() + " - " +
	    this.getCategory() + " - "  + this.authors.toString() + " : " + this.getCost() + "$";
    }

	@Override
	public String play() {
		// TODO Auto-generated method stub
		return "This method is not valid in this type of media";
	}
}
