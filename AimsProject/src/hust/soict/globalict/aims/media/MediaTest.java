package hust.soict.globalict.aims.media;

import java.util.List;
import java.util.ArrayList;

public class MediaTest {
	public static void main(String[] args) {
		List<Media> media = new ArrayList<Media>();
		
		// Create some media
		CompactDisc cd = new CompactDisc("Star Wars-2", "Scienctific", 100);
		DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Scienctific", 100);
		Book book = new Book("Star Wars-3", "Scienctific", 100);
		
		media.add(cd);
		media.add(dvd);
		media.add(book);
		
		for (Media m:media) {
			System.out.println(m.toString());
		}
	}

	public MediaTest() {
		// TODO Auto-generated constructor stub
	}

}
