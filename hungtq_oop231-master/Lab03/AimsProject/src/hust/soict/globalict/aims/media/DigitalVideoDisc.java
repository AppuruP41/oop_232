package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDirector() {
        return this.director;
    }

    public int getLength() {
        return this.length;
    }

    public float getCost() {
        return this.cost;
    }

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc( String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;
        this.length = length;
    }
    
    @Override
    public String toString() {
    	return ". DVD - " + this.getTitle() + " - " +
	    this.getCategory() + " - " + this.getDirector() + " - "
	    + this.getLength() + " : " + this.getCost() + "$";
    }
    
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

}
