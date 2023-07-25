import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int count = 0;
		int sum = 0;

		while (count < 2000 && sum < 2147483647) {
			int a = scanner.nextInt();

			if (a != -1) {
				count++;
				sum += a;
			} else break;
		}
		
		System.out.println(sum);
	}
}