package First;

public class Card {

	private int rank;
	private int suit;
	
	
	//Default Constructor creates an Ace of Spaces
	public Card(){
		setRank(1);
		setSuit(4);
	}
	
	public Card(int inRank, int inSuit){
		setRank(inRank);
		setSuit(inSuit);
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	public String getCard(){
		String currentCard;
		
		if(rank == 1){
			currentCard = "D";
		}
		else if(rank == 2){
			currentCard = ""
		}
		
		
		return card;
	}
	
	
	
	
}
