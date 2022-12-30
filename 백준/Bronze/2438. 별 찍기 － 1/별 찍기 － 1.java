import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int userNumber = scanner.nextInt();

		for (int i = 0; i < userNumber; i++) {

			String starWidth = "";

			for (int j = 0; j <= i; j++) {
				starWidth += "*";
			}

			System.out.println(starWidth);
		}
	}
}