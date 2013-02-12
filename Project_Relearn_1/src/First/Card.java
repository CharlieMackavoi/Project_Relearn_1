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
		
		//Assigns the correct suit letter
		if(suit == 1){
			currentCard = "D";
		}
		else if(suit == 2){
			currentCard = "H";
		}
		else if(suit == 3){
			currentCard = "C";
		}
		else if(suit ==  4){
			currentCard = "S";
		}
		else{
			currentCard = "Joker";
		}
		
		
		//If the card is not a joker, it adds the rank
		if(currentCard != "Joker"){
			if(rank == 1){
				currentCard = "A" + currentCard;
			}
			else if(rank == 11){
				currentCard = "J" + currentCard;
			}
			else if(rank == 12){
				currentCard = "Q" + currentCard;
			}
			else if(rank == 13){
				currentCard = "K" + currentCard;
			}
			else{
				currentCard = String.valueOf(rank) + currentCard;
			}
		}
		
		return currentCard;
	}
	
	//Returns the value of the card. Aces are 1, Jacks are 11, Queens 12, Kings 13
	public int cardValue(){
		return rank;
	}
	
	
	
	
}
