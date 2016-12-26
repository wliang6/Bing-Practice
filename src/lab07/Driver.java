package lab07;

public class Driver {

	public static void main(String[] args) throws Exception{
		FileBuffer fileBuffer = new FileBuffer("src/lab07/example.txt");
		ScratchBuffer scratchBuffer = new ScratchBuffer();
		ShellBuffer shellBuffer = new ShellBuffer();
		
		Editor fileEditor = new Editor(fileBuffer);
		Editor scratchEditor = new Editor(scratchBuffer);
		Editor shellEditor = new Editor(shellBuffer);
		
		System.out.println("\n ------------- Testing FileBuffer.. -------------");
		fileEditor.type("\n");
		fileEditor.type(" Hello. This is a test for FileBuffer");
		fileEditor.save();
		fileEditor.draw();
		
		System.out.println("\n ------------- Testing ScratchBuffer.. -------------");
		scratchEditor.type("\n");
		scratchEditor.type("Hello. This is a test for ScratchBuffer");
		scratchEditor.draw();
		scratchEditor.save();
		
//		scratchEditor.type("");
//		scratchEditor.draw();
//		scratchEditor.save();

		
		System.out.println("\n ------------- Testing ShellBuffer.. -------------");
		shellEditor.type("ls");
		shellEditor.type("pwd");
		shellEditor.type("date");
		shellEditor.type("who");
		shellEditor.type("man");
		shellEditor.type("mkdir newdirectory");
		shellEditor.type("ls");
		shellEditor.type("cd newdirectory");
		shellEditor.type("ls");
		shellEditor.draw();
		shellEditor.save();
	}

}
