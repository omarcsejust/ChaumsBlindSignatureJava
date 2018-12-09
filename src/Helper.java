import java.math.BigInteger;

public class Helper {
	
	public BigInteger calculateD(BigInteger fiOfn, int e) {
		BigInteger d = null;
		BigInteger product = fiOfn.multiply(new BigInteger("2")).add(new BigInteger("1"));
		d = product.divide(new BigInteger(Integer.toString(e)));
		return d;
	}

}
