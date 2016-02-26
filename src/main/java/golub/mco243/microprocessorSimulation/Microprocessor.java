package golub.mco243.microprocessorSimulation;

public class Microprocessor {

	private char[] memory;
	private int accumulatorA;
	private int accumulatorB;
	private int index;
	private String hex;
	private int number;

	public Microprocessor(char[] instructions) {
		memory = instructions;
		index = 0;
		accumulatorA = 0;
		accumulatorB = 0;
		getInstructions();
	}

	public char[] getInstructions() {
		char value;
		while (index < memory.length) {
			value = memory[index];
			instructions(value);
		}
		return memory;
	}

	private void instructions(char code) {
		switch (code) {
		case '0':
			hex = memory[index + 1] + "" + memory[index + 2];
			number = Integer.parseInt(hex, 16);
			accumulatorA = Integer.parseInt((memory[number] + ""), 16);
			index += 3;
			break;
		case '1':
			hex = memory[index + 1] + "" + memory[index + 2];
			number = Integer.parseInt(hex, 16);
			memory[number] = (Integer.toString(accumulatorA, 16).toUpperCase()).charAt(0);
			index += 3;
			break;
		case '2':
			int temp;
			temp = accumulatorA;
			accumulatorA = accumulatorB;
			accumulatorB = temp;
			index += 1;
			break;
		case '3':
			number = accumulatorA + accumulatorB;
			hex = Integer.toString(number, 16).toUpperCase();
			if (hex.length() == 2) {
				accumulatorA = Integer.parseInt((hex.charAt(1) + ""), 16);
				accumulatorB = Integer.parseInt((hex.charAt(0) + ""), 16);
			} else {
				accumulatorA = Integer.parseInt(hex, 16);
				;
				accumulatorB = 0;
			}
			index += 1;
			break;
		case '4':
			accumulatorA++;
			if (accumulatorA == 16) {
				accumulatorA = 0;
			}
			index += 1;
			break;
		case '5':
			accumulatorA--;
			if (accumulatorA == -1) {
				accumulatorA = 15;
			}
			index += 1;
			break;
		case '6':
			if (accumulatorA == 0) {
				hex = memory[index + 1] + "" + memory[index + 2];
				index = Integer.parseInt(hex, 16);
			} else {
				index += 3;
			}
			break;
		case '7':
			hex = memory[index + 1] + "" + memory[index + 2];
			index = Integer.parseInt(hex, 16);
			break;
		case '8':
			index = 256;
			break;

		}
	}
}
