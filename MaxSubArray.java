package com.yihao.test;

/**
 * link: https://leetcode.com/problems/maximum-subarray/
 * 
 * @author yanyihao
 *
 */
public class MaxSubArray {
	
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int len = nums.length;
		int cur = 0;

		for (int i = 0; i < len; i++) {
			cur = cur + nums[i];
			max = cur > max ? cur : max;
			if (cur < 0)
				cur = 0;
		}
		return max;
	}
}
