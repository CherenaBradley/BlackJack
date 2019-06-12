
public class Card {

	private Ranks rank;
	private Suits suit;
	
	public Card(Ranks rank, Suits suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Ranks getRank() {
		return rank;
	}
	
	public Suits getSuit() {
		return suit;
	}
	
	public String toString() {
		return rank + " " + suit;
	}
	
}
