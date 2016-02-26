package golub.mco243.microprocessorSimulation;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import golub.mco243.microprocessorSimulation.Microprocessor;

public class MicroprocessorTest {

	@Test
	public void TestMicroprocessor() throws IOException {

		String input = "040563B14004220FF31FF041320FE31FE00C204231420003"
				+ "2041314170080000F030000000000000000000000000000000000"
				+ "00000000000000000000000000000000000000000000000000000"
				+ "00000000000000000000000000000000000000000000000000000"
				+ "0000000000000000000000000000000000000000000000001";
		char[] instructions = input.toCharArray();
		Microprocessor microp = new Microprocessor(instructions);
		String output = String.valueOf(instructions);
		String output2 = "040563B14004220FF31FF041320FE31FE00C20423"
				+ "1420003204131417008000011F0000000000000000000000000000"
				+ "000000000000000000000000000000000000000000000000000000"
				+ "000000000000000000000000000000000000000000000000000000"
				+ "000000000000000000000000000000000000000000000000000E1";
		Assert.assertEquals(output2, output);
	}

}
