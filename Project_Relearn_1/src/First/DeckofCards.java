package First;

public class DeckofCards {
	
	private static final int NCards = 52;
	private Card[] deckOfCards;
	
	//Constructor method to create a new deck
	public DeckofCards(){
		deckOfCards = new Card[NCards];
		
		int i = 0;
		
		for(int suit = 1; suit <= 4; suit++){
			for(int rank = 1; rank <= 13; rank++){
				deckOfCards[i++] = new Card(rank,suit);
			}
		}
		
	}
	
	//Gets a card from a position in the deck
	public String getCard(int number){
		String card;
		
		card = deckOfCards[number].getCard();
		
		
		return card;
	}
	
	//method to shuffle a created deck
	public void shuffleDeck(){
		Card temp;
		int x;
		
		
		//3 levels of shuffle in each pass of the loop
		for(int counter = 0; counter < 4000000; counter++){
			x = (int) (Math.random() * 50 + 1);
			
			//Random elements are switched in the array 
			temp = deckOfCards[x];
			deckOfCards[x] = deckOfCards[x+1];
			deckOfCards[x+1] = temp;
			
			//The first element is switched with a random element
			temp = deckOfCards[0];
			deckOfCards[0] = deckOfCards[x % 7];
			deckOfCards[x % 7] = temp;
			
			//The last element is switched with a random element
			temp = deckOfCards[51];
			deckOfCards[51] = deckOfCards[x % 9];
			deckOfCards[x % 9] = temp;
		}
		
	}
	
	

}
