package First;

import java.util.Scanner;


public class BlackJack {
	private DeckofCards BJDeck;
	private int cardCounter = 0;
	private int balance;
	private String current;
	private int playerValue = 0; //Cards total to check for BJ for the player
	private int dealerValue = 0; //Cards total to check for BJ for the dealer
	
		public BlackJack(){
			BJDeck = new DeckofCards();
			BJDeck.shuffleDeck();
			setBalance(1000);
		}
		
		public BlackJack(DeckofCards newDeck, int inBalance){
			BJDeck = newDeck;
			BJDeck.shuffleDeck();
			setBalance(inBalance);
		}
		
		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

		public String hit(int player){
			boolean flag = false; //Flag for hands with the special case (ACES)
			int cardValue;
				if(cardCounter >= 52){
					BJDeck.shuffleDeck();
					cardCounter = 0;
				}
				current = BJDeck.getCard(cardCounter);
				cardValue = BJDeck.cardValue(cardCounter);
			
				cardCounter++;
			return current;
		}
		
		
		//Needs exception handling
		@SuppressWarnings("resource")
		public void playBlackJack(){
			int bet = 0;
			int dealer = 0; //Flag for dealer hit
			int player = 1; //Flag for player hit
			
			
			System.out.println("Welcome to Blackjack!");
			System.out.println("How much money would you like to play with?");
			@SuppressWarnings("resource") //Needs Exception handling
			Scanner user_input = new Scanner( System.in );
			balance = user_input.nextInt();
			System.out.println("Your balance is $" + balance);
		
			
			//Deciding whether to make it text base
			
			
			do{
			System.out.println("Place your bet between $5-$100");
			Scanner current_Bet = new Scanner( System.in ); //Needs exception handling
			bet = current_Bet.nextInt();
			
			
			System.out.println("Dealer");
			System.out.println(hit(dealer));
			System.out.println("XX");
			System.out.println(" ");
			System.out.println("Your Cards");
			System.out.println(hit(player));
			System.out.println(hit(player));
			System.out.println(playerValue);
			
			
			
			
			
			}while(balance > 0);
		}


}
