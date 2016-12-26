package assignment07;

public class Smart implements Play {
	
	@Override
	public int takeTurn(int currentState) {
		int i = 1;
		if(currentState == 0) return currentState;
		if(isPowerOf2Minus1(currentState)) return currentState;
		while(i != (currentState + 1)/2){
			i *= 2;
		}
		return i - 1;
	}
	
	public boolean isPowerOf2Minus1(int num){
		int i = 1;
		while(i <= num){
			if(i-1 == num){
				return true;
			}
			i *= 2;
		}
		return false;
	}

}
