import java.math.BigInteger;
import java.util.Random;

public class Helper {
	
	public BigInteger calculateD(BigInteger fiOfn, int e) {
		BigInteger d = null;
		BigInteger product = fiOfn.multiply(new BigInteger("2")).add(new BigInteger("1"));
		d = product.divide(new BigInteger(Integer.toString(e)));
		return d;
	}
	
	public BigInteger generateRandomNumberBetweenN(BigInteger n) {
		// TODO Auto-generated method stub
		Random random = new Random();
		BigInteger r = new BigInteger(n.bitLength(),random);
		return r;
	
	}

}
