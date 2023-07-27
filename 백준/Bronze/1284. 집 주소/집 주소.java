import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 숫자로 해보려고 했는데 잘 안되어서 문자열로 변경
		Scanner scanner = new Scanner(System.in);

		while (true) {
			// *** while문 밖에 선언하면 무한루프
			String s = scanner.nextLine();
			int length = 0;

			if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 9999) {
				// *** String 값비교 == 아닌 equals로 하기
				if (s.equals("0")) break;
				else {
					// 각 숫자마다 cm 측정
					for (int i = 0; i < s.length(); i++) {

						String[] sFilter = s.split("");

						if (sFilter[i].equals("0")) {
							length += 4;
						} else if (sFilter[i].equals("1")) {
							length += 2;
						} else {
							length += 3;
						}
					}

					// 각 자리수 -1마다 1cm씩, 양쪽 1cm씩 추가
					length += s.length() - 1 + 2;

					System.out.println(length);
				}
			}
		}
	}
}