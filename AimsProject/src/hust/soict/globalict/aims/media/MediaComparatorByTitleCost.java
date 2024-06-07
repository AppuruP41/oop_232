package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media media1, Media media2) {
		// TODO Auto-generated method stub
		try {
			int titleComparison = media1.getTitle().compareTo(media2.getTitle());
			if (titleComparison != 0) {
				return titleComparison;
			}
			return Double.compare(media1.getCost(), media2.getCost());
		} catch (NullPointerException | ClassCastException e) {
			throw new RuntimeException("Error comparing media objects: " + e.getMessage());
		}
	}

}
