package golub.mco243.compiler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		String fileName = "assembly.txt";
		Compiler compiler;
		try {
			compiler = new Compiler(fileName);
			System.out.println(compiler.getMachineCode());
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		} catch (IOException e) {
			System.out.println("Error with file.");
		}

	}

}
