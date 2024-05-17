package hust.soict.globalict.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track() {
		
	}

	@Override
	public String play() {
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		// TODO Auto-generated method stub
		stringBuffer.append("Playing DVD: ");
		stringBuffer.append(this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		return result;
	}
	
	public boolean equals(Track track) {
		return (this.title == track.title) && (this.length == track.length );
	}

}
