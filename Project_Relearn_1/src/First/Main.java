package First;

import javax.swing.JOptionPane;

public class Main {
	public static void main (String [] args){
		
	
	DeckofCards firstDeck;
	
	firstDeck = new DeckofCards();
	
	firstDeck.shuffleDeck();
	
	if (JOptionPane.showConfirmDialog(null, "Do you want to play Blackjack?", "Request", 
		    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
		    == JOptionPane.YES_OPTION)
		{
		BlackJack game1 = new BlackJack();
		game1.playBlackJack();
		}
		else
		{
		 System.out.println("Maybe next time");
		}
	
	
	
	
	
	}
	
}
