import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int userChoice = scanner.nextInt();

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", userChoice, i, userChoice * i);
		}
	}
}