import java.util.Random;


public class DeckOfCards {
	private int numberCards;
	private int highestValue;
	private int cardsLeft;
	private Card[] cards;
	private String[] suits;
	Random rand;
	
	public DeckOfCards() {
		highestValue = 14;
		numberCards = 52;
		cards = new Card[numberCards];
		suits = new String[4];
		rand = new Random();

		suits[0] = "Spades";
		suits[1] = "Hearts";
		suits[2] = "Clubs";
		suits[3] = "Diamonds";

		createNewDeck();
		shuffle();
		
		cardsLeft = numberCards-1;
	}

	public void createNewDeck() {

		for(int i = 2; i <= highestValue; i++) {
			for(int j = 0; j < 4; j++) {
				
				if(i == highestValue) {
					Card c = new Card(suits[j], i);
					c.setProxy("Ace");
					c.setName();
					addCardToDeck(c);
				}
				else if(i == 11) {
					Card c = new Card(suits[j], i);
					c.setProxy("Jack");
					c.setName();
					addCardToDeck(c);
				}
				else if(i == 12) {
					Card c = new Card(suits[j], i);
					c.setProxy("Queen");
					c.setName();
					addCardToDeck(c);
				}
				else if(i == 13) {
					Card c = new Card(suits[j], i);
					c.setProxy("King");
					c.setName();
					addCardToDeck(c);
				}
				else {
					Card c = new Card(suits[j], i);
					c.setName();
					addCardToDeck(c);
				}		
			}
		}
	}
	
	public Card[] getCards() {
		return cards;
	}

	public void shuffle() {
		for(int i = 0; i < 100; i++) {
			int maximum = 52;
			int randomNumber = rand.nextInt(maximum);
			int randomNumber2 = rand.nextInt(maximum);
			swap(randomNumber, randomNumber2);
		}
	}
	
	public void swap(int i, int j) {
		Card temp = new Card("", 0);
		if(cards[i].hasProxy()) {
			temp.setNumber(cards[i].getNumber());
			temp.setSuit(cards[i].getSuit());
			temp.setProxy(cards[i].getProxy());
			temp.setName();
		}
		else {
			temp.setNumber(cards[i].getNumber());
			temp.setSuit(cards[i].getSuit());
			temp.setProxy("");
			temp.setName();
		}
		cards[i] = cards[j];
		cards[j] = temp;
	}

	public void addCardToDeck(Card c) {
		for(int i = 0; i < numberCards; i++) {
			if(cards[i] == null) {
				cards[i] = c;
				break;
			}
		}
	}

	public void printDeck() {
		for(int i = 0; i < numberCards; i++) {
			System.out.println(cards[i].getNumber() + " of " + cards[i].getSuit());
		}
	}
	
	public int getCardsLeft() {
		return cardsLeft;
	}
	
	public void removeTopCard() {
		cards[0] = null;
		cardsLeft --;
		
		for(int i = 0; i < numberCards; i++) {
			if (i+1 == numberCards) {
				cards[i] = null;
				break;
			}
			cards[i] = cards[i+1];
		}
	}
	
	public Card playTopCard() {
		return cards[0];
	}
	
	public boolean compareCard(Card[] cards) {
		if (this.cards[0].getNumber() > cards[0].getNumber()) {
			return true;
		}
		else
			return false;
	}
	
	public boolean isDeckEmpty(Card[] cards) {
		if( cards[0]== null) {
			return true;
		}
		else 
			return false;
	}
	
	public Card[] getDeck() {
		return this.cards;
	}
}
