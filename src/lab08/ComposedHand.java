package lab08;

import java.util.ArrayList;

public class ComposedHand {

	private ComputationMethod method;
	ArrayList <Card> cards = new ArrayList<>();
	
	public ComposedHand(ComputationMethod m){
		method = m;
	}
	
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
	
	public int value(){
		return method.compute(cards);
	}
}
