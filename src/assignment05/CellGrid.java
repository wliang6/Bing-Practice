package assignment05;

public class CellGrid
{
	private boolean[][] cells;
	private int maxRows;
	private int maxCols;
	public CellGrid(int mRows, int mCols)
	{
		maxRows = mRows;
		maxCols = mCols;
		cells = new boolean[mRows][mCols];
		for(int i = 0; i < mRows; i++)
			for(int j = 0; j < mCols; j++)
				cells[i][j] = false;
	}

	public boolean[][] getCells() {
		return cells;
	}

	public void randomStart()
	{
		java.util.Random random = new java.util.Random();
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = random.nextBoolean();		
	}
	
	public void applyUpdate()
	{
		int [][] array = new int [maxRows][maxCols];

		
		for(int row = 0; row < maxRows; row++){ // iterate through all rows
		    for(int col = 0; col < maxCols; col++){ // iterate through all columns
		        int count = 0; // reset the counter
		        for(int rowOffs = -1; rowOffs <= 1; rowOffs++){ // offset to cover all rows in the neighborhood
		            for(int colOffs = -1; colOffs <= 1; colOffs++){ // offset to cover all columns in the neighborhood
		                int posX = col + colOffs; // actual position
		                int posY = row + rowOffs; // actual position
//		                if ((posY >= 0) && (posY < maxRows) && // Make sure to be in the valid row range
//		                    (posX >=0) && (posX < maxCols) ||  // Make sure to be in the valid column range
//		                    ((colOffs != 0) && (rowOffs != 0))) { // Exclude self - current array element 
		                if(posY >= 0 && posY < maxRows && posX >=0 && posX < maxCols){
	                		if(posX != 0 && posY != 0){
	                			if (cells[posY][posX]) { // check if the cell is true
			                        count++; // increment counter
			                    }
	                		}
		                	
//		                	if (cells[posY][posX] == true) { // check if the cell is true
//		                        count++; // increment counter
//		                    }
//		                
		                }
		            }
		        }
		        
		        array[row][col] = count; // for each current index of matrix, insert the # count of neighbors
	
		        if(cells[row][col] == false && array[row][col] == 3){
		        	cells[row][col] = true; 
		        }
		        if(cells[row][col] == true && array[row][col] > 3){
		        	cells[row][col] = false;
		        }
		        if(cells[row][col] == true && array[row][col] < 2){
		        	cells[row][col]= false; 
		        }
				
		    }
		}
//		
//		for(int row = 0; row < maxRows; row++){
//			for(int col = 0; col < maxCols; col++){
//				if(cells[row][col] == false && array[row][col] == 3){
//					cells[row][col] = true; 
//				}
//				if(cells[row][col] == true && array[row][col] > 3){
//					cells[row][col] = false;
//				}
//				if(cells[row][col] == true && array[row][col] < 2){
//					cells[row][col]= false; 
//				}
//			}
//		}
		
	}
		
//		
//		for(int row = 1; row < maxRows - 1; row++){ // iterate through all rows
//		    for(int col = 1; col < maxCols - 1; col++){ // iterate through all columns
//		        int count = 0; // reset the counter
//		        for(int rowOffs = -1; rowOffs <= 1; rowOffs++){ // offset to cover all rows in the neighborhood
//		            for(int colOffs = -1; colOffs <= 1; colOffs++){ // offset to cover all columns in the neighborhood
//		                int posX = col + colOffs; // actual position
//		                int posY = row + rowOffs; // actual position
//		                if ((posY >= 0) && (posY < maxRows) && // Make sure to be in the valid row range
//		                    (posX >=0) && (posX < maxCols) ||  // Make sure to be in the valid column range
//		                    ((colOffs != 0) && (rowOffs != 0))) { // Exclude self - current array element 
//		                    if (cells[posY][posX]) { // check if the cell is true
//		                        count++; // increment counter
//		                    }
//		                
//		                }
//		            }
//		        }
//		        
//		        array[row][col] = count; // for each current index of matrix, insert the # count of neighbors
//	
//		        if(cells[row][col] == false && array[row][col] == 3){
//		        	cells[row][col] = true; 
//		        }
//		        if(cells[row][col] == true && array[row][col] > 3){
//		        	cells[row][col] = false;
//		        }
//		        if(cells[row][col] == true && array[row][col] < 2){
//		        	cells[row][col]= false; 
//		        }
//				
//		    }
//		}
		
//		for(int row = 0; row < maxRows; row++){
//			for(int col = 0; col < maxCols; col++){
//		        if(cells[row][col] == false && array[row][col] == 3){
//		        	cells[row][col] = true; 
//		        }
//		        if(cells[row][col] == true && array[row][col] > 3){
//		        	cells[row][col] = false;
//		        }
//		        if(cells[row][col] == true && array[row][col] < 2){
//		        	cells[row][col]= false; 
//		        }
//			}
//		}
		
		
//		for (int i = 0 ; i < maxRows ; i++) {
//			for (int j = 0 ; j < maxCols ; j++) {
//				int trueNeighbors = 0;
//				boolean topLeft = cells[i-1][j-1];
//				boolean topMiddle = cells[i-1][j];
//				boolean topRight = cells[i-1][j+1];
//				boolean middleLeft = cells[i][j-1];
//				boolean middle = cells[i][j];
//				boolean middleRight = cells[i][j+1];
//				boolean bottomLeft = cells[i+1][j-1];
//				boolean bottomMiddle = cells[i+1][j];
//				boolean bottomRight = cells[i+1][j+1];
//				
//				
//				if(i > 1 && j > 1 && i < maxRows - 1 && j < maxCols - 1){ 				//check top row and check left column
//					if(topLeft == true) trueNeighbors++;
//					if(topMiddle == true) trueNeighbors++;
//					if(topRight == true) trueNeighbors++;
//					if(middleLeft == true) trueNeighbors++;
//					if(middleRight == true) trueNeighbors++;
//					if(bottomLeft == true) trueNeighbors++;
//					if(bottomMiddle == true) trueNeighbors++;
//					if(bottomRight == true) trueNeighbors++;
//				} 
//				if(i <= 1 && j <= 1)
//
//
//
//				
//				array[i][j] = trueNeighbors; 
//			}
//		}
	
				
//				
//				
//				if(i > 1 && i < maxRows - 1 && j > 1 && j < maxCols - 1){			//check all 8 neighbors
//					if(topLeft == true) trueNeighbors++;
//					if(topMiddle == true) trueNeighbors++;
//					if(topRight == true) trueNeighbors++;
//					
//					if(bottomLeft == true) trueNeighbors++; 
//					if(bottomMiddle == true) trueNeighbors++;
//					if(bottomRight == true) trueNeighbors++;
//					
//					if(middleLeft == true) trueNeighbors++;					
//					if(middleRight == true) trueNeighbors++;
//					
//					
//				}
//				
				
				
				
//				if(i == 0 && j == 0){ //first edge case -- top left corner
//					if(middleRight == true) trueNeighbors++;
//					if(bottomMiddle == true) trueNeighbors++;
//					if(bottomRight == true) trueNeighbors++;
//				}
//				
//				if(i == 0 && j == maxCols - 1){ //top right corner
//					if(middleLeft == true) trueNeighbors++;
//					if(bottomLeft == true) trueNeighbors++;
//					if(bottomMiddle == true) trueNeighbors++;
//				}
//				
//				if(i == maxRows - 1 && j == 0){ //bottom left corner
//					if(topMiddle == true) trueNeighbors++;
//					if(topRight == true) trueNeighbors++;
//					if(middleRight == true) trueNeighbors++;	
//				}
//				
//				if(i == maxRows - 1 && j == maxCols - 1){ //bottom right corner
//					if(middleLeft == true) trueNeighbors++;
//					if(topLeft == true) trueNeighbors++;
//					if(topMiddle == true) trueNeighbors++;
//				}
				
				
				
				


				
				
					

	

	public void gosperStart() {
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = false;
		cells[5][1] = true;
		cells[5][2] = true;
		cells[6][1] = true;
		cells[6][2] = true;
		cells[1][25] = true;
		cells[2][23] = true;
		cells[2][25] = true;
		cells[3][13] = true;
		cells[3][14] = true;
		cells[3][21] = true;
		cells[3][22] = true;
		cells[3][35] = true;
		cells[3][36] = true;
		cells[4][12] = true;
		cells[4][16] = true;
		cells[4][21] = true;
		cells[4][22] = true;
		cells[4][35] = true;
		cells[4][36] = true;
		cells[5][11] = true;
		cells[5][17] = true;
		cells[5][21] = true;
		cells[5][22] = true;
		cells[6][11] = true;
		cells[6][15] = true;
		cells[6][17] = true;
		cells[6][18] = true;
		cells[6][23] = true;
		cells[6][25] = true;
		cells[7][11] = true;
		cells[7][17] = true;
		cells[7][25] = true;
		cells[8][12] = true;
		cells[8][16] = true;
		cells[9][13] = true;
		cells[9][14] = true;		
	}

	public void gliderStart() {
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = false;
		cells[1][3] = true;
		cells[2][4] = true;
		cells[3][2] = true;
		cells[3][3] = true;
		cells[3][4] = true;
	}
}