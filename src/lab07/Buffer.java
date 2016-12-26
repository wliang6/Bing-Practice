package lab07;

import java.util.List;

public class Buffer {

	protected List<String> lines;
	
	public int getNumLines(){
		return lines.size();
	}
	
	public String getText(){
		return String.join("\n", this.lines);
	}
	
	public void draw(){
		System.out.println(this.getText());
	}
	
	public void save() throws UnsupportedOperationException{
	}
	
	public void type(String toType){
		if(lines.isEmpty()){
			lines.add("");
		}
		for(int i = 0; i < toType.length(); i++){
			if(toType.charAt(i) == '\n'){
				lines.add("");
			} else{
				String line = lines.get(lines.size() - 1);
				line = line + Character.toString(toType.charAt(i));
				lines.set(lines.size() - 1, line);
			}
			
		}
	}
}
