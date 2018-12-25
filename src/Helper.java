import java.math.BigInteger;
import java.util.Random;

public class Helper {
	
	// method for blinding the message using user public keys e,n
	public BigInteger blindMessage(BigInteger r, BigInteger m, BigInteger n, BigInteger e) {
		BigInteger cipher = r.modPow(e, n);
		BigInteger blingMsg = cipher.multiply(m);
		return blingMsg;
	}
	
	// signer sign the message using private key d
	public BigInteger signMessage(BigInteger blindMessage, BigInteger d, BigInteger n) {
		BigInteger sign = blindMessage.modPow(d, n);
		return sign;
	}
	
	// message is being unblinded
	public BigInteger unblindMessage(BigInteger sign, BigInteger r, BigInteger n) {
		BigInteger r_inv = r.modInverse(n);
		BigInteger unblindMsg = (sign.multiply(r_inv)).mod(n);
		return unblindMsg;
	}

}
