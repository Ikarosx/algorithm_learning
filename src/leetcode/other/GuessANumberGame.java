package leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The goal of this game is to guess a 4-digit number according to the game rules. There is a host and a player. The
project is designed such that the computer can be either the host or the player. The game is as follows:
1. The host picks a 4-digit number (i.e. any number between 1000 and 9999). Let’s call this the groundtruth
number. In the following example, let’s pick 5432 as the groundtruth.
2. The player takes a guess, for example, 1234.
3. The host tells the player how many digits of the guess number match the groundtruth. A match is defined as the
same digit in the same position. For example, 1234 and 5432 have 1 match (at position 3); 2345 and 5432 have
0 match – even though it’s the same set of digits, none matches in the exact same position.
4. Based on the number of matches, the player performs some update and takes another guess, say 5533.
5. The host again tells the player the number of matches. This time, 5533 and 5432 have 2 matches.
6. Repeat steps 4 and 5 until the game is over. The game is over when the host tells the player that all 4 digits are
matched. Therefore the player has found the groundtruth number.
Ideally, you want to design an algorithm that allows the player to succeed with as few guesses as possible. A trivial
solution could take guesses continuously from 1000 to 9999, ignoring the information that the host tells the player
in each round. But this is too brute-force and would result in thousands of guesses, which is unacceptable. How
can you design a better algorithm to solve the problem much faster? Such an algorithm should make good use of
the information about the number of matches that the host tells the player in each round of the game. Take a break
and think about a solution on your own. In the next page you will find the description of an algorithm you MUST
implement for this project.
 * @author Ikaros
 *
 */
public class GuessANumberGame {
	static int time = 0;

	private static int GuessANumberGame(int num) {
		int count = 0;

		// map存储结果中数字出现的次数，比较次数为10次
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= 9; i++) {
			int num2 = i * 1000 + i * 100 + i * 10 + i;
			int match = howManyMatch(num2);
			if (match != 0) {
				map.put(i, match);
			}
		}
		// 得到未使用的数字，0不算
		int unUseful = -1;
		for (int i = 1; i < 9; i++) {
			boolean flag = true;
			for (int j : map.keySet()) {
				if (i == j) {
					flag = false;
					break;
				}
			}
			if (flag) {
				unUseful = i;
				break;
			}
		}
		// 需要使用未使用的数字*1000去测试有几个0，不然可能出现测试1000，实际上1也出现了的情况
		int match = howManyMatch(unUseful * 1000);
		if (match != 0) {
			map.put(0, match);
		}
		/*
		 * arr数组保存的全为未使用数字 测试思路如下，从倒数替换arr数组中的值，来组成xxxx四位数
		 * 假如该测试数得到的匹配结果>目前已经确认的正确数(即howManyMatch(?)>count) 就将arr数组中对应下标的值替换为正确结果
		 * 循环直至howManyMatch返回4
		 */ int[] arr = { unUseful, unUseful, unUseful, unUseful };
		for (Entry<Integer, Integer> i : map.entrySet()) {
			Integer key = i.getKey();
			for (int j = 0; j < i.getValue(); j++) {
				for (int k = 3; k >= 0; k--) {
					int temp = 0;
					int mul = 1;
					for (int l = 3; l >= 0; l--) {// 最多4次
						temp += l == k ? key * mul : arr[l] * mul;
						mul *= 10;
					}
					if (howManyMatch(temp) > count) {
						count++;
						arr[k] = key;
						if (count == 4) {
							return count;
						}
						break;
					}
				}
			}
		}
		return count;
	}

	private static int howManyMatch(int num) {
		assert (num >= 1000 && num <= 9999);
		System.out.println(String.format("你比较的数字是:%d", num));
		time++;
		int count = 0;
		int target = 1111;
		int temp = 1000;
		for (int i = 0; i < 4; i++) {
			if (num / temp == target / temp) {
				count++;
			}
			num -= num / temp * temp;
			target -= target / temp * temp;
			temp /= 10;
		}
		System.out.println(String.format("这个数字出现了正确数字%d个\n", count));
		return count;
	}

	public static void main(String[] args) {
		GuessANumberGame(2562);
		System.out.println(String.format("一共花费了%d次进行比较", time));
		// System.out.println(howManyMatch(6666));
	}
}
