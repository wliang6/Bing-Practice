package ArrayStats;
// Make a class ArrayStats. It has six private fields:
// • an array of double,
// • a double for the average of all the elements in the array,
// • a double for the maximum element,
// • a double for the minimum element,
// • an int for the first index of the minimum element,
// • an int for the first index of the maximum element.

public class ArrayStats {
	private double[] data;
	private double avg;
	private double max;
	private double min;
	private int maxIdx;
	private int minIdx;

	// If the array field is null or empty, the double fields will be 0 and the int fields will be -1. 
	// The constructor will use the vararg notation on Slide 3.11  
	public ArrayStats(double... vals) {
		// in the constructor assign vals as the value of the array field 
		// and compute the other 5 fields if vals is not null or empty and 
		// do all these 5 computations using one for loop.
		data = vals; 
		if(vals == null || vals.length <= 0){ //if the array field is null or empty
			avg = 0.0;
			max = 0.0;
			min = 0.0;
			maxIdx = -1;
			minIdx = -1;
			
		}else{  //if the array field is not null nor empty
			double sum = 0;
			double maximum = data[0];
			double minimum = data[0];
			for(int i = 0; i < data.length; i++){
				sum += data[i];
				if(data[i] > max){
					maximum = data[i];
					max = maximum;
					maxIdx = i;
				}
				if(data[i] < min){
					minimum = data[i];
					min = minimum;
					minIdx = i;
				}
			}
			avg = (double)sum / (double)data.length;
		}
	}

	// Write public getter methods. To allow testing by the TAs, call the getters: getData(), getMax, getMin, getMaxIdx, getMinIdx, getAvg.
	public double [] getData(){
		return this.data;
	}

	public double getMax(){
		return this.max;
	}

	public double getMin(){
		return this.min;
	}

	public int getMaxIdx(){
		return this.maxIdx;
	}

	public int getMinIdx(){
		return this.minIdx;
	}

	public double getAvg(){
		return this.avg;
	}
}


