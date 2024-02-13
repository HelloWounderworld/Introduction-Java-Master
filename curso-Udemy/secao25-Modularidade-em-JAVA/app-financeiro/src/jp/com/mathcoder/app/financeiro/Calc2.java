package jp.com.mathcoder.app.financeiro;

import java.util.Arrays;

public class Calc2 implements Calc {

	@Override
	public double soma(double... nums) {
		return Arrays.stream(nums).reduce(0.0, (t, a) -> t + a);
	}
}
