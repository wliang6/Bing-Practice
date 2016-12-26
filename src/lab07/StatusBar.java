package lab07;

public class StatusBar extends Buffer{

	private Buffer attachedTo;
	public StatusBar(Buffer buffer){
		attachedTo = buffer;
	}
	
	@Override
	public String getText(){
		String numberOfLines = Integer.toString(attachedTo.getNumLines());
		return new String("-- lines: " + numberOfLines + " --");
	}
	

}
