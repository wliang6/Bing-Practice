//Author Kevin Tarczali
package project;

import java.awt.GridLayout;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MachineModel {
	public final Map<Integer, Instruction> INSTRUCTIONS = new TreeMap<>();
	Code code = new Code();
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private HaltCallback callback;
	Job[] jobs = new Job[2];
	private Job currentJob;
	/**
	 * Default constructor, doesn't really do anything
	 */
	public MachineModel() {
		this(() -> System.exit(0));
	}
	/**
	 * Constructor to be used in usual circumstances
	 * @param callback
	 */
	public MachineModel(HaltCallback callback) {
		jobs[0] = new Job();
		jobs[1] = new Job();
		currentJob = jobs[0];
		jobs[0].setStartcodeIndex(0);
		jobs[0].setStartmemoryIndex(0);
		jobs[1].setStartcodeIndex(Code.CODE_MAX / 4);
		jobs[1].setStartmemoryIndex(Memory.DATA_SIZE / 2);

		this.callback = callback;
		// INSTRUCTION_MAP entry for "NOP"
		INSTRUCTIONS.put(0x0, arg -> {
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "LODI"
		INSTRUCTIONS.put(0x1, arg -> {
			cpu.setAccumulator(arg);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "LOD"
		INSTRUCTIONS.put(0x2, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			cpu.setAccumulator(arg1);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "LODN"
		INSTRUCTIONS.put(0x3, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			int arg2 = memory.getData(cpu.getMemoryBase() + arg1);
			cpu.setAccumulator(arg2);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "STO"
		INSTRUCTIONS.put(0x4, arg -> {
			memory.setData(cpu.getMemoryBase() + arg, cpu.getAccumulator());
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "STON"
		INSTRUCTIONS.put(0x5, arg -> {
			// x=memory[arg + memorybase]
			// memory[memory base + x]=accumulator

			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			memory.setData(arg1 + cpu.getMemoryBase(), cpu.getAccumulator());
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "JMPI"
		INSTRUCTIONS.put(0x6, arg -> {
			cpu.setInstructionPointer(cpu.getInstructionPointer() + arg);
		});

		// INSTRUCTION_MAP entry for "JUMP"
		INSTRUCTIONS.put(0x7, arg -> {
			cpu.setInstructionPointer(cpu.getInstructionPointer() + memory.getData(cpu.getMemoryBase() + arg));
		});

		// INSTRUCTION_MAP entry for "JMZI"
		INSTRUCTIONS.put(0x8, arg -> {
			if (cpu.getAccumulator() == 0)
				cpu.setInstructionPointer(cpu.getInstructionPointer() + arg);
			else
				cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "JMPZ"
		INSTRUCTIONS.put(0x9, arg -> {
			if (cpu.getAccumulator() == 0)
				cpu.setInstructionPointer(cpu.getInstructionPointer() + memory.getData(cpu.getMemoryBase() + arg));
			else
				cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "ADDI"
		INSTRUCTIONS.put(0xA, arg -> {
			cpu.setAccumulator(cpu.getAccumulator() + arg);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "ADD"
		INSTRUCTIONS.put(0xB, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			cpu.setAccumulator(cpu.getAccumulator() + arg1);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "ADDN"
		INSTRUCTIONS.put(0xC, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			int arg2 = memory.getData(cpu.getMemoryBase() + arg1);
			cpu.setAccumulator(cpu.getAccumulator() + arg2);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "SUBI"
		INSTRUCTIONS.put(0xD, arg -> {
			cpu.setAccumulator(cpu.getAccumulator() - arg);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "SUB"
		INSTRUCTIONS.put(0xE, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			cpu.setAccumulator(cpu.getAccumulator() - arg1);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "SUBN"
		INSTRUCTIONS.put(0xF, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			int arg2 = memory.getData(cpu.getMemoryBase() + arg1);
			cpu.setAccumulator(cpu.getAccumulator() - arg2);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "MULI"
		INSTRUCTIONS.put(0x10, arg -> {
			cpu.setAccumulator(cpu.getAccumulator() * arg);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "MUL"
		INSTRUCTIONS.put(0x11, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			cpu.setAccumulator(cpu.getAccumulator() * arg1);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "MULN"
		INSTRUCTIONS.put(0x12, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			int arg2 = memory.getData(cpu.getMemoryBase() + arg1);
			cpu.setAccumulator(cpu.getAccumulator() * arg2);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "DIVI"
		INSTRUCTIONS.put(0x13, arg -> {
			if (arg == 0)
				throw new DivideByZeroException();
			cpu.setAccumulator(cpu.getAccumulator() / arg);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "DIV"
		INSTRUCTIONS.put(0x14, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			if (arg1 == 0)
				throw new DivideByZeroException();
			cpu.setAccumulator(cpu.getAccumulator() / arg1);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "DIVN"
		INSTRUCTIONS.put(0x15, arg -> {
			int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			int arg2 = memory.getData(cpu.getMemoryBase() + arg1);
			if (arg2 == 0)
				throw new DivideByZeroException();
			cpu.setAccumulator(cpu.getAccumulator() / arg2);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "ANDI"
		INSTRUCTIONS.put(0x16, arg -> {
			if (cpu.getAccumulator() != 0 && arg != 0)
				cpu.setAccumulator(1);

			else
				cpu.setAccumulator(0);

			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "AND"
		INSTRUCTIONS.put(0x17, arg -> {
			if (cpu.getAccumulator() != 0 && memory.getData(arg + cpu.getMemoryBase()) != 0)
				cpu.setAccumulator(1);
			else
				cpu.setAccumulator(0);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "NOT"
		INSTRUCTIONS.put(0x18, arg -> {
			if (cpu.getAccumulator() != 0)
				cpu.setAccumulator(0);
			else
				cpu.setAccumulator(1);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "CMPL"
		INSTRUCTIONS.put(0x19, arg -> {
			if (memory.getData(cpu.getMemoryBase() + arg) < 0)
				cpu.setAccumulator(1);
			else
				cpu.setAccumulator(0);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "CMPZ"
		INSTRUCTIONS.put(0x1A, arg -> {
			if (memory.getData(cpu.getMemoryBase() + arg) == 0)
				cpu.setAccumulator(1);
			else
				cpu.setAccumulator(0);
			cpu.incrementIP();
		});

		// INSTRUCTION_MAP entry for "HALT"
		INSTRUCTIONS.put(0x1F, arg -> {
			callback.halt();
		});
	}

	/**
	 * Return the cpu
	 * 
	 * @return current CPU in the form of the CPU class
	 */
	public CPU getCpu() {
		return cpu;
	}

	/**
	 * get the current job
	 * 
	 * @return Job current job
	 */
	public Job getCurrentJob() {
		return currentJob;
	}

	/**
	 * Return the instruction at index i
	 * 
	 * @param i
	 * @return Instruction at index i
	 */
	public Instruction get(int i) {
		return INSTRUCTIONS.get(i);
	}

	/**
	 * 
	 * @return memory
	 */
	public Memory getMemory() {
		return memory;
	}

	/**
	 * Sets the current cpu to the parameter
	 * 
	 * @param cpu
	 */
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	/**
	 * Sets current memory to arg memory
	 * 
	 * @param memory
	 */
	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	/**
	 * Return the instruction pointer from the cpu
	 * 
	 * @return int value of instruction pointer
	 */
	public int getInstructionPointer() {
		return cpu.getInstructionPointer();
	}

	/**
	 * Return the accumulator value from the cpu
	 * 
	 * @return int value of accumulator
	 */
	public int getAccumulator() {
		return cpu.getAccumulator();
	}

	/**
	 * Get int array of data from memory
	 * 
	 * @return int[] from memory
	 */
	public int[] getData() {
		return memory.getData();
	}

	/**
	 * Sets this cpu accumulator to i
	 * 
	 * @param i
	 *            is set as the accumulator value
	 */
	public void setAccumulator(int i) {
		cpu.setAccumulator(i);

	}

	/**
	 * Set data at index i to value j
	 * 
	 * @param i
	 *            int, index
	 * @param j
	 *            int, value
	 */
	public void setData(int i, int j) {
		memory.setData(i, j);
	}

	/**
	 * Set current job to job at index i in array jobs, jobs[i] = currentJob
	 * 
	 * @param i,
	 *            index
	 */
	public void setJob(int i) {
		if (i != 0 || i != 1)
			throw new IllegalArgumentException();
		currentJob.setCurrentAcc(cpu.getAccumulator());
		currentJob.setCurrentIP(cpu.getInstructionPointer());

		jobs[i] = currentJob;
		cpu.setAccumulator(currentJob.getCurrentAcc());
		cpu.setInstructionPointer(currentJob.getCurrentIP());
		cpu.setMemoryBase(currentJob.getStartmemoryIndex());
	}

	/**
	 * Set the instruction pointer to int i
	 * 
	 * @param i
	 *            int, value of pointer
	 */
	public void setInstructionPointer(int i) {
		cpu.setInstructionPointer(i);
	}

	/**
	 * Set op code and arg in code using index i
	 * 
	 * @param i
	 * @param op
	 * @param arg
	 */
	public void setCode(int i, int op, int arg) {
		code.setCode(i, op, arg);
	}

	/**
	 * Get code
	 * 
	 * @return
	 */
	public Code getCode() {
		return code;
	}

	/**
	 * Return value at memory[i]
	 * 
	 * @param i
	 * @return
	 */
	public int getData(int i) {
		return memory.getData(i);
	}

	/**
	 * Set memory base as the initial offset
	 * 
	 * @param offsetinit,
	 *            start of memory base
	 */
	public void setMemoryBase(int offsetinit) {
		cpu.setMemoryBase(offsetinit);

	}

	/**
	 * Get current state from current job
	 * 
	 * @return
	 */
	States getCurrentState() {
		return currentJob.getCurrentState();
	}

	/**
	 * Set current state of job as arg currentState
	 * 
	 * @param currentState
	 */
	void setCurrentState(States currentState) {
		currentJob.setCurrentState(currentState);
	}

	/**
	 * Imagine as taking one step in the line of code. Does one line of code
	 * then stops. Could be used to see how memory, cpu, and registers change as
	 * code is processed
	 */
	void step() {
		try {
			if (cpu.getInstructionPointer() < currentJob.getStartcodeIndex()
					|| cpu.getInstructionPointer() > currentJob.getStartcodeIndex() + currentJob.getCodeSize())
				throw new CodeAccessException();
			int opcode = code.getOp(cpu.getInstructionPointer());
			int arg = code.getArg(cpu.getInstructionPointer());
			get(opcode).execute(arg);
		} catch (Exception e) {
			callback.halt();
			throw e;
		}
	}
	/**
	 * Gets rid of the current job from memory, cpu, code, and current job
	 */
	void clearJob() {
		memory.clear(currentJob.getStartmemoryIndex(), currentJob.getStartmemoryIndex() + Memory.DATA_SIZE / 2);
		code.clear(currentJob.getStartcodeIndex(), currentJob.getStartcodeIndex() + currentJob.getCodeSize());
		cpu.setAccumulator(0);
		cpu.setInstructionPointer(currentJob.getStartcodeIndex());
		currentJob.reset();
	}
	
	public int getMemoryBase() {
		return cpu.getMemoryBase();
	}
	
	public static class AccumulatorViewPanel implements Observer {
		private MachineModel model;
		private JTextField acc = new JTextField(); 

		public AccumulatorViewPanel(ViewsOrganizer gui, MachineModel model) {
			this.model = model;
			gui.addObserver(this);
		}

		public JComponent createProcessorDisplay() {
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1,0));
			panel.add(new JLabel("Accumulator: ", JLabel.RIGHT));
			panel.add(acc);
			return panel;
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			if(model != null) {
				acc.setText("" + model.getAccumulator());
			}
		}
		
		public static void main(String[] args) {
			ViewsOrganizer view = new ViewsOrganizer(); 
			MachineModel model = new MachineModel();
			AccumulatorViewPanel panel = 
				new AccumulatorViewPanel(view, model);
			JFrame frame = new JFrame("TEST");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 60);
			frame.setLocationRelativeTo(null);
			frame.add(panel.createProcessorDisplay());
			frame.setVisible(true);
		}
		
		
	}
}
