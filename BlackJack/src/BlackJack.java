import java.util.Scanner;


public class BlackJack {

	//private static int HandValue;
	
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);	
	
		int Bank = 200;
		int Bet;
		
		boolean GameOver ;
						
		System.out.println("Welcome to BlackJack!!" );
		
		
		while(true) {
			System.out.println("You have $" + Bank );
					
			do {
				System.out.println("How much would you like to bet?");
				Bet = in.nextInt();
				
				if(Bet > Bank || Bet < 0) {
					
					System.out.println("Invalid amount! must be above 0 but below " + Bank);
					
				}
				//Bank -= Bet;
			} 
			while(Bet > Bank || Bet < 0);
		
			if(Bet == 0)
				break;
			GameOver = Play();
			if(GameOver)
				Bank = Bank + Bet;
			else {
				Bank = Bank - Bet;
			}
			if(Bank == 0) {
				System.out.println("You ran out of money! GameOVER!");
				break;
			}
		}
	}
			
	
		
	 static boolean Play() {
		
		Scanner in = new Scanner(System.in);
		
		Hand Player = new Hand();
		Hand Dealer = new Hand();
		Deck deck = new Deck();
		deck.shuffle();
		
		Player.addCard(deck.draw());
		Player.addCard(deck.draw());
		
		Dealer.addCard(deck.draw());
		Dealer.addCard(deck.draw());
		
		if(Player.HandValue() == 21) {
			System.out.println("Player Hand: "+ "\n"  + Player.HandString(false));	
			System.out.println("BLACKJACK!! YOU WIN!!");
			return true;
		}
		if(Dealer.HandValue() == 21) {
				
			System.out.println("BLACKJACK!! Dealer WINS!!");
			System.out.println("Dealer Hand"+ "\n"  + Dealer.HandString(false));
			return false;
		}
		
		while(true) {
			System.out.println("Dealer Hand:"+ "\n"  + Dealer.HandString(true));
			System.out.println("Player Hand:" + "\n" + Player.HandString(false));
			System.out.println("Player Hand Total: " + Player.HandValue());
			System.out.println("Hit or Stay?");
			String Ans = in.nextLine();
			
			switch(Ans) {
			
			case "Hit" :
			case "hit" : 
			Player.addCard(deck.draw());
			System.out.println("Player Hand:" + "\n" + Player.HandString(false));
			System.out.println("Player Hand Total:" + Player.HandValue());
			System.out.println("Dealer Hand:" + Dealer.HandString(true));
			
			if(Player.HandValue() > 21) {
			System.out.println("Dealer Hand" + "\n"  + Dealer.HandString(false));
			System.out.println("Bust!! You lose!!");
			return false;
			}
			break;
			
			case "Stay" :
			case "stay" :
			System.out.println("Dealer Hand:" + "\n" + Dealer.HandString(false));
			
			while(Dealer.HandValue() <= 16) {
				System.out.println("Dealer Hit because player stays");
				Dealer.addCard(deck.draw());
				if(Dealer.HandValue() > 21) {
					System.out.println("Dealer Busted!! You Win!!");
					return true;
				}
			}
			break;
			default:
				System.out.println("Invalid Response! Hit or Stay?");
			break;
			}
			if(Dealer.HandValue() == Player.HandValue()) {
				System.out.println("Push!! Both have same values");
				System.out.println("Dealer Hand:" + "\n"  + Dealer.HandString(false));
				System.out.println("Dealer Hand Total: " +  Dealer.HandValue());
				System.out.println("Player Hand:"+ "\n"   + Player.HandString(false));
				System.out.println("Player Hand Total: " +  Player.HandValue());
				return false;
			}
			else if(Dealer.HandValue() > Player.HandValue()) {
				System.out.println("Dealer Wins!");
				System.out.println("Dealer Hand" + "\n" + Dealer.HandString(false));
				System.out.println("Dealer Hand Total: " +  Dealer.HandValue());
				System.out.println("Player Hand"+ "\n"  + Player.HandString(false));
				System.out.println("Player Hand Total: " +  Player.HandValue());
				return false;
			}
			else {
				System.out.println("Player Wins!");
				System.out.println("Player Hand"+ "\n"  + Player.HandString(false));
				System.out.println("Player Hand Total: " +  Player.HandValue());
				System.out.println("Dealer Hand" + "\n" + Dealer.HandString(false));
				System.out.println("Dealer Hand Total: " +  Dealer.HandValue());
				
				return true;
			}
			
		
		}
		
		//return false;
	}
}

