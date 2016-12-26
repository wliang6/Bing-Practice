package lab07;

/*
 * Special kind of buffer backed by file
 */
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileBuffer extends Buffer {

	private String filename;
	public FileBuffer(String s){
		filename = s;
		
		try{
			Path filepath = Paths.get(filename);
			lines = Files.readAllLines(filepath, Charset.defaultCharset());
		} catch(IOException e){
			lines = new ArrayList<>();
		}
	}

	@Override
	public void save() throws UnsupportedOperationException{
		try{
			Path filepath = Paths.get(filename);
			Files.write(filepath, lines, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
