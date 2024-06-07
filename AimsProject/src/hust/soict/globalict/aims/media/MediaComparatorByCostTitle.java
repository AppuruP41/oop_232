package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media media1, Media media2) {
		// TODO Auto-generated method stub
		try {
			int costComparison = Double.compare(media1.getCost(), media2.getCost());
			if (costComparison != 0) {
				return costComparison;
			}
			return media1.getTitle().compareTo(media2.getTitle());
		} catch (NullPointerException | ClassCastException e) {
			throw new RuntimeException("Error comparing media objects: " + e.getMessage());
		}
		
	}

}
