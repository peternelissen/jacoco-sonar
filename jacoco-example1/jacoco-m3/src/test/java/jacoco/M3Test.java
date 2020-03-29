package jacoco;

import org.junit.Test;

import static org.junit.Assert.*;

public class M3Test {

	@Test
	public void methodM3_calledBy_M3() {
		new M3().methodM3_calledBy_M3();
	}

	@Test
	public void methodM1_calledBy_M3() {
		new M1().methodM1_calledBy_M3();
	}

	@Test
	public void methodM2_calledBy_M3() {
		new M2().methodM2_calledBy_M3();
	}
}