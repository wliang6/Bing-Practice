package lab08;

public class BlackjackHand extends CardHand{
	
	@Override
	public int value() {
		int sum = 0;
		int aces = 0;
		for (Card c : cards) {
			if (c.getValue() == 11 || c.getValue() == 1){
				aces++;
			} else{
				sum += c.getValue();
			}
		}
		if (aces > 0) {
			if (aces > 1){
				sum += aces - 1;
			}
			if ((sum + 11) <= 21){
				sum += 11;
			}
			else{
				sum++;
			}
		}
		return sum;
	}


}
