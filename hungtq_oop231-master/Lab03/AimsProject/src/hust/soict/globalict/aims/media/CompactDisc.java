package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;



public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return this.artist;
	}
	
	public void addTrack(Track track) {
		if(this.tracks.contains(track)) {
			System.out.println("The track is already exist");
		}
		else {
			this.tracks.add(track);
		}
	}
	
	
	public void removeTrack(Track track) {
		if(!this.tracks.contains(track)) {
			System.out.println("The follow track is not exist");
		}
		else {
			this.tracks.remove(track);
		}
	}
	
	public int getLength() {
		int length = 0;
		for (Track track: tracks) {
			length += track.getLength();
		}
		return length;
	}
	
	public CompactDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

	@Override
	public void play() {
		// TODO Auto-generated method stub
		for (Track track: this.tracks) {
			System.out.println("Playing DVD: " + track.getTitle());
			System.out.println("DVD length: " + track.getLength());
		}
	}
	
	@Override
    public String toString() {
    	return ". CD - " + this.getTitle() + " - " +
	    this.getCategory() +  " : " + this.getCost() + "$";
    }
}
