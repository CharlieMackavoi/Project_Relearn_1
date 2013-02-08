package First;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.BadLocationException;

public class BlackJack {
	private DeckofCards BJDeck;
	private int cardCounter = 0;
	private int balance;
	private String current;
	
	
		public BlackJack(){
			BJDeck = new DeckofCards();
			setBalance(1000);
		}
		
		public BlackJack(DeckofCards newDeck, int inBalance){
			BJDeck = newDeck;
			setBalance(inBalance);
		}
		
		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

		public String hit(){
			if(cardCounter >= 52){
			BJDeck.shuffleDeck();
			cardCounter = 0;
			}
			current = BJDeck.getCard(cardCounter);
			cardCounter++;
			return current;
			
		}
		
		
		//Needs exception handling
		public void playBlackJack(){
			System.out.println("Welcome to Blackjack!");
			System.out.println("How much money would you like to play with?");
			@SuppressWarnings("resource") //Needs Exception handling
			Scanner user_input = new Scanner( System.in );
			balance = user_input.nextInt();
			System.out.println("Your balance is $" + balance);
			
			//Deciding whether to make it text base
			
			
		}


}
