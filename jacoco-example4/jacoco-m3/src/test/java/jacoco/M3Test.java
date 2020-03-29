package jacoco;

import jacoco.M1;
import jacoco.M2;
import jacoco.M3;
import org.junit.Test;

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