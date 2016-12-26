package lab07;

public class Editor {

	private Buffer buffer;
	private StatusBar sb;
	public Editor(Buffer b){
		buffer = b;
		sb = new StatusBar(b);
	}
	
	//Delegation methods
	public void draw(){ 
		buffer.draw();
		sb.draw();
	}

	public void save() throws UnsupportedOperationException {
		buffer.save();
	}

	public void type(String toType) {
		buffer.type(toType);
	}
	
	
}
