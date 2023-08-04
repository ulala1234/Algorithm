import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		// 문제 이해가 더 어려웠음, 쪼개면 값이 어떻게 나올까 생각해서 풀음
		// n은 가로로 쪼갠 개수, m은 그 중 세로로 쪼갠 개수를 n번함
		// 어차피 문제에서 1 * 1 크기의 초콜릿으로 쪼갠다 했으니 n = m 값이긴 한데 (m - 1) * m이라고 하니 틀렸다고 나옴
		// -----1. 쪼갠 선으로 생각
		System.out.println((n - 1) + (m - 1) * n);
		
		// -----2. 결과 값으로 생각
		//System.out.println(n * m - 1);
	}
}