//Author Kevin Tarczali
package project;

public class Job {
	private int startcodeIndex;
	private int codeSize;
	private int startmemoryIndex;
	private int currentIP;
	private int currentAcc;
	private States currentState;
	
	public int getStartcodeIndex() {
		return startcodeIndex;
	}
	public int getCodeSize() {
		return codeSize;
	}
	public int getCurrentState() {
		return codeSize;
	}
	public int getStartmemoryIndex() {
		return startmemoryIndex;
	}
	public int getCurrentIP() {
		return currentIP;
	}
	public int getCurrentAcc() {
		return currentAcc;
	}
	public void setStartcodeIndex(int startcodeIndex) {
		this.startcodeIndex = startcodeIndex;
	}
	public void setCodeSize(int codeSize) {
		this.codeSize = codeSize;
	}
	public void setStartmemoryIndex(int startmemoryIndex) {
		this.startmemoryIndex = startmemoryIndex;
	}
	public void setCurrentIP(int currentIP) {
		this.currentIP = currentIP;
	}
	public void setCurrentAcc(int currentAcc) {
		this.currentAcc = currentAcc;
	}
	public void setCurrentState(States currentState) {
		this.currentState = currentState;
	}
	void reset(){
		codeSize = currentAcc = 0;
		currentIP = startcodeIndex;
		currentState = States.NOTHING_LOADED;
	}
}
