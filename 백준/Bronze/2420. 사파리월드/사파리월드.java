import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		BigInteger n = scanner.nextBigInteger();
		BigInteger m = scanner.nextBigInteger();

		BigInteger abs = n.subtract(m).abs();

		System.out.println(abs);
	}
}