package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Loader {
	public static String load(MachineModel model, File file, int codeOffset, int memoryOffset){
		int codeSize = 0;
		if(file == null || model == null)
			return null;
		try {
			Scanner input = new Scanner(file);
			boolean incode = true;
			int op;
			int arg;
			
			
			while(input.hasNextLine()){
				String line = input.nextLine();
				Scanner parser = new Scanner(line);
				op = parser.nextInt(16);
				
				if(incode && op==-1){
					incode = false;
				}
				else if(incode && op!= -1){
					arg = parser.nextInt(16);
					model.setCode(codeOffset+codeSize, op, arg);
					codeSize++;
					
				}
				else if(!incode){
					arg = parser.nextInt(16);
					model.setData(memoryOffset+op, arg);
				}
				parser.close();
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("File " + file.getName() + " Not Found");
		} 
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Array Index " + e.getMessage());
		} 
		catch (NoSuchElementException e) {
			System.out.println("From Scanner: NoSuchElementException");
			e.printStackTrace();
		}
		
		return ""+codeSize;
	}
	
	// ----------------------------------------------
	public static void main(String[] args) {
		MachineModel model = new MachineModel();
		String s = Loader.load(model, new File("C:/Users/Alan/workspace/Workspace2/Project/src/project/factorial.pasm"), 100, 200);
		for(int i = 100; i < 100+Integer.parseInt(s); i++) {
			System.out.println(model.getCode().getText(i));			
		}
		
		System.out.println(200 + " " + model.getData(200));
	}
}
