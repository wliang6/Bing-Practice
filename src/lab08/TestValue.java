package lab08;

import static org.junit.Assert.*;

import lab08.Card.Suit;

import org.junit.Test;

public class TestValue {
	

	@Test
	public void test1() {
		BlackjackHand deck = new BlackjackHand();
		Card c1 = new Card(Suit.Hearts, 2);
		Card c2 = new Card(Suit.Spades, 4);
		deck.addCard(c1); deck.addCard(c2);
		assertTrue(deck.value() == 6);
	}
	
	@Test
	public void test2() {
		BlackjackHand deck = new BlackjackHand();
		Card c1 = new Card(Suit.Diamonds, 11);
		Card c2 = new Card(Suit.Diamonds, 10);
		deck.addCard(c1); deck.addCard(c2);
		assertTrue(deck.value() == 21);
	}

	@Test
	public void test3() {
		BlackjackHand deck = new BlackjackHand();
		Card c1 = new Card(Suit.Diamonds, 11);
		Card c2 = new Card(Suit.Diamonds, 11);
		deck.addCard(c1); deck.addCard(c2);
		assertTrue(deck.value() == 12);
	}
	
	@Test
	public void test4() {
		BlackjackHand deck = new BlackjackHand();
		Card c1 = new Card(Suit.Diamonds, 11);
		Card c2 = new Card(Suit.Diamonds, 11);
		Card c3 = new Card(Suit.Hearts, 11);
		deck.addCard(c1); deck.addCard(c2); deck.addCard(c3);
		assertTrue(deck.value() == 13);
	}
	
	@Test
	public void test5() {
		BlackjackHand deck = new BlackjackHand();
		Card c1 = new Card(Suit.Diamonds, 10);
		Card c2 = new Card(Suit.Diamonds, 10);
		Card c3 = new Card(Suit.Spades, 2);
		deck.addCard(c1); deck.addCard(c2); deck.addCard(c3);
		assertTrue(deck.value() == 22);
	}
	
	@Test
	public void test6() {
		BlackjackHand deck = new BlackjackHand();
		Card c1 = new Card(Suit.Diamonds, 10);
		Card c2 = new Card(Suit.Diamonds, 10);
		Card c3 = new Card(Suit.Spades, 11);
		deck.addCard(c1); deck.addCard(c2); deck.addCard(c3);
		assertTrue(deck.value() == 21);
	}
}
