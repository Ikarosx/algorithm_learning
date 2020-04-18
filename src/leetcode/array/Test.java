package leetcode.array;

public class Test {
	public static void main(String[] args) {
		int s = 5, i = 10;
		do {
			i *= s--;
		} while (s == 0);
		System.out.println(i);
	}
}
