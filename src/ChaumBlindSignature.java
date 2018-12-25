import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class ChaumBlindSignature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper helper = new Helper();
		Scanner scanner = new Scanner(System.in);
		
		BigInteger phi_n = Components.p.subtract(BigInteger.ONE).multiply(Components.q.subtract(BigInteger.ONE));
		BigInteger n = Components.p.multiply(Components.q);
		
		// input your message
		System.out.println("Input your message");
		BigInteger msg = scanner.nextBigInteger();
		
		// blinding phase
		BigInteger blindMsg = helper.blindMessage(Components.r, msg, n, Components.e);
		
		// signing phase
		BigInteger signMsg = helper.signMessage(blindMsg, Components.d, n);
		
		//unblind phase
		BigInteger unblindMsg = helper.unblindMessage(signMsg, Components.r, n);
		
		// verify phase
		BigInteger verifyMsg = unblindMsg.modPow(Components.e, n);
		
		System.out.println("Your Message: "+msg);
		System.out.println("Bling Message: "+blindMsg);
		System.out.println("Sign Message: "+signMsg);
		System.out.println("Unblind Message: "+unblindMsg);
		System.out.println("Verified Message: "+verifyMsg);
	}

}
