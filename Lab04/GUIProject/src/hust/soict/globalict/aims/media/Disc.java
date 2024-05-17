package hust.soict.globalict.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc() {
		super();
		this.length = 0;
	}

}
