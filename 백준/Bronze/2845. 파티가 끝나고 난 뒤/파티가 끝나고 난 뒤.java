import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int l = scanner.nextInt();
		int p = scanner.nextInt();
		int[] a = new int[5];

		// 원래 숫자 제한 두려했는데 문제에 입력값이 제한적으로 주어진다 되어있어서 뺌
        // 배열로 넣을 때 방법(검색)
		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] - l * p + " ");
		}
	}
}