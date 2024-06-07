package hust.soict.globalict.aims.media;

import java.util.Comparator;

import hust.soict.globalict.aims.exception.PlayerException;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(Media media) {
		return this.title == media.title;
	}
	
	public int isMatch(String title) {
		return this.title.compareTo(title);
	}
	
	public String play() throws PlayerException {
		return "ERROR:";
	}

}
