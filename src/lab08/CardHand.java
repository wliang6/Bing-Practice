package lab08;

import java.util.ArrayList;

public abstract class CardHand {
	ArrayList <Card> cards = new ArrayList<>();
	
	public void addCard(Card c) {
		if(c != null){
			cards.add(c);
		}
	}
	
	public void clear(){
		cards.clear();
	}
	
	public String toString() {
		String s = cards.toString();
		return s;
	}
	
	public abstract int value();

}
