package assignment07;

public class Greedy implements Play {

	@Override
	public int takeTurn(int currentState) {
		if(currentState <= 1) return 1;
		else{
			return currentState/2;
		}
		
	}

}
