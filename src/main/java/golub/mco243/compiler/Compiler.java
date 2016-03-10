package golub.mco243.compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Compiler {
	private StringBuilder machineCode;

	public Compiler(String fileName) throws IOException {
		machineCode = new StringBuilder();
		BufferedReader input = new BufferedReader(new FileReader(fileName));
		String inputCode;
		while ((inputCode = input.readLine()) != null) {
			
			String[] tokens = inputCode.split(" ");
			switch (tokens[0]) {
			case "LD":
				this.machineCode.append("0");
				this.machineCode.append(tokens[1]);
				break;
			case "ST":
				this.machineCode.append("1");
				this.machineCode.append(tokens[1]);
				break;
			case "SWP":
				this.machineCode.append("2");
				break;
			case "ADD":
				this.machineCode.append("3");
				break;
			case "INC":
				this.machineCode.append("4");
				break;
			case "DEC":
				this.machineCode.append("5");
				break;
			case "BZ":
				this.machineCode.append("6");
				this.machineCode.append(tokens[1]);
				break;
			case "BR":
				this.machineCode.append("7");
				this.machineCode.append(tokens[1]);
				break;
			case "STP":
				this.machineCode.append("8");
				break;
			case "DATA":
				this.machineCode.append(tokens[1]);
				break;
			}
		}
		input.close();
	}

	public String getMachineCode() {
		return machineCode.toString();
	}

	

}