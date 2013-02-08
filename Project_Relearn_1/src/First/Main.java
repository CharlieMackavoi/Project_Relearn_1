package First;

public class Main {
	public static void main (String [] args){
		
	
	DeckofCards firstDeck;
	
	firstDeck = new DeckofCards();
	
	int i = 0;
	
	while(i<52){
	System.out.println(firstDeck.getCard(i));
	i++;
	}
	
	}
	
}
