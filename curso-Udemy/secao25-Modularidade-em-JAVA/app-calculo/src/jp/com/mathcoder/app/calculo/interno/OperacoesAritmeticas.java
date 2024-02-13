package jp.com.mathcoder.app.calculo.interno;

import java.util.Arrays;
import jp.com.mathcoder.app.loggin.Logger;

public class OperacoesAritmeticas {

	public double soma(double... nums) {
		Logger.info("Somando...");
		return Arrays.stream(nums).reduce(0.0, (t, a) -> t + a);
	}
}
