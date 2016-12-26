package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Assembler {
	public static void main(String[] args){
		
		File inputFile = new File("C:/Users/Alan/workspace/Workspace2/Project/src/project/test.txt");
		File outputFile = new File("C:/Users/Alan/workspace/Workspace2/Project/src/project/testOut.txt");
		System.out.println(assemble(inputFile,outputFile));
	}
	
	public static String assemble(File input, File output) {
		ArrayList<String> code = new ArrayList<>(); 
		ArrayList<String> data = new ArrayList<>();
		ArrayList<String> outText = new ArrayList<>();
		String[] parts;
		int opcode;
		Scanner inputFile;
		
		try {
			
			inputFile = new Scanner(input);
			while (inputFile.hasNext()) {
				String line = inputFile.nextLine();
				
				if(line.trim().equals("DATA")){
					
					while (inputFile.hasNext()) {
						line = inputFile.nextLine();
						data.add(line);
					}
					
				}
				else{
					
					parts = line.trim().split("\\s+");
					if(parts.length==2){
						
						if(parts[1].startsWith("#")){
							
							if(parts[0].equals("JUMP")){
								parts[0]="JMP";
							}
							if(parts[0].equals("JMPZ")){
								
								parts[0]="JMZ";
								
							}
							parts[1] = parts[1].substring(1);
							parts[0]+="I";
							
						}
						if(parts[1].startsWith("&")){
							parts[1] = parts[1].substring(1);
							parts[0]+="N";
						}
						
					}
					opcode = InstructionMap.opcode.get(parts[0]);
					if(parts.length == 1){
						outText.add(Integer.toHexString(opcode).toUpperCase() + " 0");
					}
					else if(parts.length ==2){
						outText.add(Integer.toHexString(opcode).toUpperCase() + " " + parts[1]);
					}
					code.add(line);
				}
			}
			
			inputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		outText.add("-1");
		outText.addAll(data);
		
		try {
			PrintWriter out = new PrintWriter(output);
			
			for(int i=0;i<outText.size();i++){
				out.println(outText.get(i));
			}
			out.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return "success";
	}
}
