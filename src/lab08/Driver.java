package lab08;

import java.util.List;

import lab08.Card.Suit;

public class Driver {

	public static void main(String[] args) {
		
		//Static behavior - extension through subclassing
		BlackjackHand hand = new BlackjackHand();
		
		Card card1 = new Card(Suit.Hearts, 2);
		Card card2 = new Card(Suit.Diamonds, 3);
		Card card3 = new Card(Suit.Clubs, 4);
		Card card4 = new Card(Suit.Spades, 5);
		
		hand.addCard(card1); hand.addCard(card2); 
		hand.addCard(card3); hand.addCard(card4);
		
		System.out.println(hand);
		
		
		//Dynamic behavior - composition
		BlackjackMethod method = new BlackjackMethod();
		ComposedHand composed = new ComposedHand(method);
		
		composed.addCard(card1); composed.addCard(card2);
		composed.addCard(card3); composed.addCard(card4);
		
		System.out.println(composed);
	}
	

}
