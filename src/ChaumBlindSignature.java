import java.math.BigInteger;
import java.util.Scanner;

public class ChaumBlindSignature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Helper helper = new Helper();
		
		System.out.println("Input 1st prime number");
		BigInteger p = scanner.nextBigInteger();
		
		System.out.println("Input 2nd prime number");
		BigInteger q = scanner.nextBigInteger();
		
		BigInteger n = p.multiply(q);
		
		BigInteger fiOfn = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
		
		System.out.println("Choose an integer");
		int e = scanner.nextInt();
		
		BigInteger data = helper.calculateD(fiOfn, e);
		
		System.out.println(data);
		
		
		
	}

}
