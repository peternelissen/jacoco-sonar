package jacoco;

import jacoco.M1;
import jacoco.M2;
import org.junit.Test;

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