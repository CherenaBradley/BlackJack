import java.util.ArrayList;

public class Hand {

	private final ArrayList<Card> aHand;
	
	public Hand() {
		
		this.aHand = new ArrayList<Card>();
	
	}
	
	public void addCard(Card card) {
		aHand.add(card);
	}
	public int HandValue () {
		int val = 0;
		boolean Ace = false;
		for (Card card : aHand) {
			val += card.getRank().getValue();
			if(card.getRank().getValue() == 1) {
				Ace = true;
			}
			if(Ace && val <=10) {
				val +=10;
			}
		}
		return val;
	}
	public String HandString(boolean hide) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < aHand.size(); i++) {
			if(i == 0 && hide) {
				s.append('\n');
				s.append("[Hidden]");
				s.append('\n');
				}
			else {
				s.append(aHand.get(i));
				s.append('\n');
			}
		}
		return s.toString();
	}
	public boolean BlackJack() {
		if(aHand.size() ==2 && HandValue() == 21) {
			System.out.println("BlackJack!");
			return true;
		}
		return false;
	}
	public boolean Bust(int HandValue) {
		if(HandValue > 21) {
			System.out.print("Bust!");
			return true;
		}
		return false;
	}
	
	
}
