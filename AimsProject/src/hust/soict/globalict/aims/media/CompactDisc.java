package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;

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
	
	public CompactDisc() {
    
	}

	public CompactDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
	
	public CompactDisc(int id, String title, String category, String director,String artist, int length , float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = id;
        this.director = director;
        this.length = length;
        this.artist = artist;
    }

	@Override
	public String play() throws PlayerException {
		
		String result;
		StringBuffer stringBuffer = new StringBuffer();
		if(this.getLength() <= 0 ) {
			stringBuffer.append("\nThis CD cannot be played!");
			throw new PlayerException("ERROR: CD is non-posititve");
		}
		
		stringBuffer.append("Playing CD: ");
		stringBuffer.append(this.getTitle());
		stringBuffer.append("\nCD length: ");
		stringBuffer.append(this.getLength());

		
		for (Track track: this.tracks) {
			if (track.getLength() > 0) {
				track.play();
				stringBuffer.append("\nPlaying Track: ");
				stringBuffer.append(track.getTitle());
				stringBuffer.append("\nTrack length: ");
				stringBuffer.append(track.getLength());
			}
			else {
				throw new PlayerException("ERROR: Track Length is non-positive");
			}
		}
		
		result = stringBuffer.toString();
		return result;
	}
	
	@Override
    public String toString() {
    	return ". CD - " + this.getTitle() + " - " +
	    this.getCategory() + " - " + this.getDirector() + " - " + this.getArtist() + " - " + this.getLength() +   " : " + this.getCost() + "$";
    }
}
