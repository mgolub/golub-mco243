package golub.mco243.microprocessorSimulation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader input = new BufferedReader(new FileReader("mach.in"));
		String line;
		while ((line = input.readLine()) != null) {
			char[] inputInstruction = line.toCharArray();
			Microprocessor microp = new Microprocessor(inputInstruction);
			System.out.println(String.valueOf(inputInstruction));
		}
		input.close();

	}

}
