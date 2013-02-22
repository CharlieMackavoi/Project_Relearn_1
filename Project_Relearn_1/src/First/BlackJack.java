package First;

import java.util.Scanner;


public class BlackJack {
	private static final int BJ_BONUS = 2; //This is the bonus multiplier the player receives for getting a BlackJack
	private DeckofCards BJDeck;
	private int cardCounter = 0;
	private int choice = 0;
	private int balance;
	private String current;
	private int playerValue = 0; //Cards total to check for BJ for the player
	private int dealerValue = 0; //Cards total to check for BJ for the dealer
	private boolean ace = false;
	private boolean dealerAce = false; //To check for insurance (If I decide to implement that)
	private String dealersCard;
	
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
			int cardValue;
				if(cardCounter >= 52){
					BJDeck.shuffleDeck();
					cardCounter = 0;
				}
				current = BJDeck.getCard(cardCounter);
				cardValue = BJDeck.cardValue(cardCounter);
				
				//This section helps break down the values of the cards
				        //10's, J's, Q's, K's all have a value of 10 in BJ
						if(cardValue > 10){
							cardValue = 10;
						}
						
						//Aces have the value of 1 or 11 depending on whether the player will be over 21
						if(cardValue == 1){
						 ace = true;
						}
						
				
							if(player == 1){
								playerValue = (playerValue + cardValue);
							}
							else{
								dealerValue = (dealerValue + cardValue);
								if(ace){
									ace = false;
									dealerAce = true;
								}
							}
				cardCounter++;
			return current;
		}
		
		//Display the hand value of the player, specifically to handle the special ACE case
		public void displayHandValue(int player)
		{
				System.out.print("Hand Value: " +  player);
				if(ace && player <= 11)
					System.out.print("/" + (player+10));
				
				//Over 21 Busts
				if(player > 21){
					System.out.println(" BUST!");
					return;
				}	
				System.out.println("   Dealer Shows a " + dealersCard);
		}
		
		//Returns the value of a hand
		public int handValue(int value){
				int handValue = value;
					if(ace && value <= 11){
						handValue = value+10;
					}
			return handValue;
		}
		
		//Once the player stands finish the dealer operations
		public void finishHand(){
			
			if(ace){
				playerValue = handValue(playerValue);
				if(!dealerAce){
					ace = false;
				}
			}
			
			
			System.out.print("Dealers hand: " + dealersCard + " ");
			
				while(dealerValue < 17){
					System.out.print(hit(0) + " ");
				}
				System.out.println();
				if(dealerValue > 21)
					dealerValue = 0;
		}
		
		
		public void winHand(int bet){
			//If there is a tie "Push" balance is unaffected
			if(dealerValue == playerValue){
				System.out.println("PUSH");
				return;
			}
			//If you beat the dealer
			if(dealerValue < playerValue && playerValue < 22){
				//If player receives Blackjack
				if(ace && playerValue == 21){
					System.out.println("You got Blackjack!!!! A multiplier of" + BJ_BONUS + ", you won $" + bet);
					balance = (balance + (bet*BJ_BONUS));
				}
				//Simply beat dealer
				else{
					System.out.println("You won $" + bet);
					balance = balance + bet;
				}
			}
			//Player bust/Dealer beat player
			else{
				System.out.println("You lost $" + bet);
				balance = balance - bet;
			}
		}
		
		//Resets all flags/values for a new hand
		public void newHand(){
			ace = false;
			dealerAce = false;
			dealerValue = 0;
			playerValue = 0;
			choice = 0;
		}
		
		
		//Needs exception handling
		@SuppressWarnings("resource")
		public void playBlackJack(){
			int bet = 0;
			int dealer = 0; //Flag for dealer hit
			int player = 1; //Flag for player hit
			
			
			System.out.println("Welcome to Blackjack!");
			System.out.println("How much money would you like to play with?");

			try {
				Scanner user_input = new Scanner( System.in );
				balance = user_input.nextInt();
			} catch (Exception e) {
				balance = 10;
				System.out.println("That is not a dollar amount, you bring $10 to the table.");
				//e.printStackTrace();
			}
			System.out.println("Your balance is $" + balance);
			
			
			do{
				Scanner current_Bet;
				
					do{
						System.out.print("Place your bet ");
						try {
							current_Bet = new Scanner( System.in );
							bet = current_Bet.nextInt();
						} catch (Exception e) {
							System.out.println("That is not a dollar amount.");
							bet = 0;
						}
				
						if(bet > balance){
							System.out.println("You can not bet more than your current balance.");
						}
				
					}while(bet > balance || bet < 1);
			
				System.out.println("Dealer");
				dealersCard = hit(dealer);
				System.out.print(dealersCard);
				System.out.println(" XX");
				System.out.println(" ");
				System.out.println("Your Cards");
				System.out.print(hit(player) + " ");
				System.out.println(hit(player));
				displayHandValue(playerValue);
				
				
				//If the user gets Blackjack they automatically win the hand
				if(ace && playerValue == 11){
					System.out.println("You got Blackjack!!!! You will receive a multiplier of " + BJ_BONUS);
					System.out.println("You won $" + (bet+bet));
					balance = balance + (bet + bet);
					newHand();
					
					System.out.println("Current balance: $" + balance);
					System.out.println();
					
					continue;
				}
				
				
				
				//Balance needs to be at least twice as big as the bet to double down.
					System.out.println("1) Hit 2)Stand 3) Double");
					try {
						current_Bet = new Scanner(System.in);
						choice = current_Bet.nextInt();
					} catch (Exception e) {
						System.out.println("That isn't an option. Dealer assumes you stand.");
						choice = 2;
					}
						
					
					if(choice == 3){
							if((bet + bet) <= balance){
									System.out.println(hit(player));
									displayHandValue(playerValue);	
									bet = bet*2;
							}
							else{
								System.out.println("You don't have enough balance to double down. You hit.");
								choice = 1;
							}
						}
				
				
					if(choice == 1){
						System.out.println(hit(player));
						displayHandValue(playerValue);	
						while(playerValue < 21){
							System.out.println("1) Hit 2)Stand");
							try {
								current_Bet = new Scanner(System.in);
								choice = current_Bet.nextInt();
							} catch (Exception e) {
								System.out.println("That isn't an option. Dealer assumes you stand.");
								choice = 2;
							}
					
								if(choice != 1){
									break;
								}
				
							System.out.println(hit(player));
							displayHandValue(playerValue);	
						}
					}
				
					//Only finish dealer hand if player has not "Bust"
					if(playerValue < 22)
						finishHand();
					if(dealerValue > 0){
						System.out.println("Dealers Value " + dealerValue + "   Your Value " + playerValue);
					}
					else{
						System.out.println("Dealer BUSTS!");
					}
				winHand(bet);
				newHand();
			
				System.out.println("Current balance: $" + balance);
				System.out.println();
			
			}while(balance > 0);
		}


}
