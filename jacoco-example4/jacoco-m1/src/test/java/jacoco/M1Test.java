package jacoco;

import jacoco.M1;
import org.junit.Test;

public class M1Test {

	@Test
	public void methodM1_calledBy_M1() {
		new M1().methodM1_calledBy_M1();
	}
}