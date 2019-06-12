import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private final ArrayList<Card> aDeck;
	
	public Deck () {
		
		aDeck = new ArrayList<Card>();
		
		for(Suits suit : Suits.values()) {
			for(Ranks rank : Ranks.values()) {
				aDeck.add(new Card(rank, suit));
				
			}
		}
		
		
		
		
	}
	
	public void shuffle() {
		Collections.shuffle(aDeck);
	}
	
	public Card draw() {
		return aDeck.remove(0);
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i <aDeck.size(); i++) {
			s.append(i + 1);
			s.append('/');
			s.append(aDeck.size());
			s.append(' ');
			s.append(aDeck.get(i));
			s.append('\n');
		}
		return s.toString();
	}
	
}