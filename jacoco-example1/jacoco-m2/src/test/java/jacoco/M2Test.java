package jacoco;

import org.junit.Test;

import static org.junit.Assert.*;

public class M2Test {

	@Test
	public void methodM2_calledBy_M2() {
		new M2().methodM2_calledBy_M2();
	}

	@Test
	public void methodM1_calledBy_M1() {
		new M1().methodM1_calledBy_M2();
	}
}