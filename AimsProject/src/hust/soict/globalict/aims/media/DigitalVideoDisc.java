package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

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

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) throws PlayerException {
        super();
        if (cost < 0) {
            throw new PlayerException("Cost should be a positive number");
        } else if ( title == "") {
            throw new PlayerException("Title should not be empty");
        }  else if ( category =="") {
            throw new PlayerException("Category should not be empty");
        } else if ( director == "") {
            throw new PlayerException("Director should not be empty");
        } if (length < 0 ) {
            throw new PlayerException("Length cannot be less than 0");
        }
        else {
            this.title = title;
            this.category = category;
            this.cost = cost;
            this.director = director;
            this.length = length;
            this.id = id;
        }
    }
    
    public DigitalVideoDisc() {
    	
	}

	@Override
    public String toString() {
    	return ". DVD - " + this.getTitle() + " - " +
	    this.getCategory() + " - " + this.getDirector() + " - "
	    + this.getLength() + " : " + this.getCost() + "$";
    }
    
	@Override
	public String play() throws PlayerException {
		String result;
		StringBuffer stringBuffer = new StringBuffer();
		if (this.getLength() > 0 ) {
			stringBuffer.append("Playing DVD: ");
			stringBuffer.append(this.getTitle());
			stringBuffer.append("\nDVD length: ");
			stringBuffer.append(this.getLength());
		}
		else {
			stringBuffer.append("\nThe DVD Cannot Be Played! ");
			throw new PlayerException("ERROR: DVD Length is non-positive");
		}
		result = stringBuffer.toString();
		return result;
	}

}
