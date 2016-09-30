package com.yihao.test;

/**
 * Link: https://leetcode.com/problems/single-number-ii/
 * 
 * @author yanyihao
 *
 */
public class SingleNumber2 {
	public int singleNumber(int[] nums) {
		int len = nums.length;
		int result = 0;

		for (int i = 0; i < 32; i++) {
			int num = 0;
			for (int j = 0; j < len; j++) {
				int cur = nums[j];
				if (((cur >> i) & 1) == 1) {
					num++;
				}
			}
			if (num % 3 == 1) {
				result |= 1 << i;
			}
		}
		return result;
	}
}
