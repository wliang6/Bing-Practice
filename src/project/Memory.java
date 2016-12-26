package project;

public class Memory {
	public static final int DATA_SIZE = 2048;
	private int[] data = new int[DATA_SIZE];
	
	int[] getData(){
		return data;
	}
	
	int getData(int index){
		return data[index];
	}
	
	void setData(int index, int value){
		data[index] = value;
	}
	
	
}
