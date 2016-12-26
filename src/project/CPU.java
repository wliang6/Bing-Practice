package project;

public class CPU {
	private int accumulator;
	private int instructionPointer;
	private int memoryBase;
	
	public void incrementIP(){
		instructionPointer++;
	}
	/**
	 * @return the accumulator
	 */
	public int getAccumulator() {
		return accumulator;
	}
	/**
	 * @return the instructionPointer
	 */
	public int getInstructionPointer() {
		return instructionPointer;
	}
	/**
	 * @return the memoryBase
	 */
	public int getMemoryBase() {
		return memoryBase;
	}
	/**
	 * @param accumulator the accumulator to set
	 */
	public void setAccumulator(int accumulator) {
		this.accumulator = accumulator;
	}
	/**
	 * @param instructionPointer the instructionPointer to set
	 */
	public void setInstructionPointer(int instructionPointer) {
		this.instructionPointer = instructionPointer;
	}
	/**
	 * @param memoryBase the memoryBase to set
	 */
	public void setMemoryBase(int memoryBase) {
		this.memoryBase = memoryBase;
	}
	
	
}
