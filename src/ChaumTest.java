import java.math.BigInteger;
import java.util.Random;

public class ChaumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bit_len = 64;
		Random rand = new Random();
		//BigInteger a = BigInteger.probablePrime(bit_len, rand);
		//System.out.println(a);
		
		BigInteger p = BigInteger.probablePrime(bit_len, rand);
		BigInteger q = BigInteger.probablePrime(bit_len, rand);
		
		//BigInteger p = new BigInteger("255718554125660544195172654530737050391");
		//BigInteger q = new BigInteger("171764555308926962724905545149993791827");
		
		BigInteger e = new BigInteger("206126578863562291471009007705531899859");
		BigInteger d = new BigInteger("3097325324669114045574261029306396823811404845714915716047145852388990536439");
		
		BigInteger r = new BigInteger("1741948824");
		
		BigInteger msg = new BigInteger("12345678922");
		
		BigInteger phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		
		BigInteger n = p.multiply(q);
		
		// blinding phase
		BigInteger cipher = r.modPow(e, n);
		BigInteger blingMsg = cipher.multiply(msg);
		
		// signing phase
		BigInteger signMsg = blingMsg.modPow(d, n);
		
		//unblind phase
		BigInteger r_inv = r.modInverse(n);
		BigInteger unblindMsg = (signMsg.multiply(r_inv)).mod(n);
		
		// verify phase
		BigInteger verifyMsg = unblindMsg.modPow(e, n);
		
		System.out.println(verifyMsg);
	}

}
