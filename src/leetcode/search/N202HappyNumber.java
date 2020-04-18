package leetcode.search;

import java.util.LinkedList;

/**
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
1^2 + 9^2 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * @author Ikaros
 *
 */
public class N202HappyNumber {
	public static boolean isHappy(int n) {
		LinkedList<Integer> dupl = new LinkedList<Integer>();
		while (n != 1) {
			if (dupl.contains(n)) {
				return false;
			} else {
				dupl.add(n);
			}
			String nS = String.valueOf(n);
			int sum = 0;
			for (int i = 0; i < nS.length(); i++) {
				sum += Math.pow(nS.charAt(i) - 48, 2);
			}
			n = sum;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19));

	}
}
