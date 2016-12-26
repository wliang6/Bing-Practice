package lab08;


public class Card {
	public static enum Suit { Hearts, Diamonds, Clubs, Spades };
	private Suit suit;
	private int value;
	
	public Card(Suit suit1, int value1) {
		if(value1 < 2 || value1 > 11) {
			throw new IllegalArgumentException("argument cannot be lower than 2 or higher than 11");
		}
		suit = suit1;
		value = value1;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other != null){
			if (other instanceof Card == false) {
				return false;
			}
			Card card = (Card)other;
			if((card.value == this.value && card.suit == this.suit)) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		int hashcode = 31 * suit.hashCode() + 7 * Integer.hashCode(value);
		return hashcode;
	}
	
	public String toString(){
		String str = "";
		if (value == 11) {
			str = str.concat("Ace");
		}
		else {
			str = str + value;
		}
		str = str.concat(" of ");
		str = str.concat(suit.toString());
		return str;
	}
	
	public static void main(String args[]) {
		Card card1 = new Card(Suit.Hearts, 2);
		Card card2 = new Card(Suit.Diamonds, 3);
		Card card3 = new Card(Suit.Clubs, 4);
		Card card4 = new Card(Suit.Spades, 5);
		Card card5 = new Card(Suit.Diamonds, 3);
		
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		System.out.println(card4);
		System.out.println(card5);
		System.out.println(card2.equals(card5)); //true
		System.out.println(card1.equals(card4)); //false
	}
}
