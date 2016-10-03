package com.yihao.test;

/**
 * Link: https://leetcode.com/problems/maximum-product-subarray/
 * @author yanyihao
 *
 */
public class MaximumProductSubarray {

	public static int maxProduct(int[] nums) {
		int len = nums.length;
		int[] min = new int[len];
		int[] max = new int[len];

		min[len - 1] = nums[len - 1];
		max[len - 1] = nums[len - 1];

		for (int i = len - 2; i >= 0; i--) {
			int cur = nums[i];
			int temp1 = cur * max[i + 1];
			int temp2 = cur * min[i + 1];
			min[i] = MIN(temp1, temp2, cur);
			max[i] = MAX(temp1, temp2, cur);
		}

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			int temp = max[i];
			result = result > temp ? result : temp;
		}
		return result;
	}

	public static int MIN(int a, int b, int c) {
		int result = a > b ? b : a;
		result = result > c ? c : result;
		return result;
	}

	public static int MAX(int a, int b, int c) {
		int result = a > b ? a : b;
		result = result > c ? result : c;
		return result;
	}
}
