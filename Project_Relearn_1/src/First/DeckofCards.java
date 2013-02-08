package First;

public class DeckofCards {
	//Creates a shuffled deck of cards
	private static final int NCards = 52;
	
	private Card[] deckOfCards;
	
	public DeckofCards(){
		deckOfCards = new Card[NCards];
		
		int i = 0;
		
		for(int suit = 1; suit <= 4; suit++){
			for(int rank = 1; rank <= 13; rank++){
				deckOfCards[i++] = new Card(rank,suit);
			}
		}
		
	}
	
	public String getCard(int number){
		String card;
		
		card = deckOfCards[number].getCard();
		
		
		return card;
	}
	
	

}
