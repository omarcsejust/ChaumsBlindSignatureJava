import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class ChaumBlindSignature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper helper = new Helper();
		Scanner scanner = new Scanner(System.in);
		
		BigInteger p = new BigInteger("255718554125660544195172654530737050391");
		BigInteger q = new BigInteger("171764555308926962724905545149993791827");
		
		BigInteger e = new BigInteger("206126578863562291471009007705531899859");
		BigInteger d = new BigInteger("3097325324669114045574261029306396823811404845714915716047145852388990536439");
		
		BigInteger r = new BigInteger("1741948824");
		
		BigInteger phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		BigInteger n = p.multiply(q);
		
		System.out.println("Input your message");
		BigInteger msg = scanner.nextBigInteger();
		
		// blinding phase
		BigInteger blindMsg = helper.blindMessage(r, msg, n, e);
		
		// signing phase
		BigInteger signMsg = helper.signMessage(blindMsg, d, n);
		
		//unblind phase
		BigInteger unblindMsg = helper.unblindMessage(signMsg, r, n);
		
		// verify phase
		BigInteger verifyMsg = unblindMsg.modPow(e, n);
		
		System.out.println("Your Message: "+msg);
		System.out.println("Bling Message: "+blindMsg);
		System.out.println("Sign Message: "+signMsg);
		System.out.println("Unblind Message: "+unblindMsg);
		System.out.println("Verified Message: "+verifyMsg);
	}

}
