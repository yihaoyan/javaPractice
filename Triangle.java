package com.yihao.test;

import java.util.List;

/**
 * Link: https://leetcode.com/problems/triangle/
 * 
 * @author yanyihao
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		int[][] dp = new int[len][len];
		List<Integer> last = triangle.get(len - 1);
		for (int i = 0; i < len; i++) {
			dp[len - 1][i] = last.get(i);
		}

		for (int i = len - 2; i >= 0; i--) {
			List<Integer> cur = triangle.get(i);
			for (int j = 0; j <= i; j++) {
				int l = dp[i + 1][j];
				int r = dp[i + 1][j + 1];
				dp[i][j] = (l > r ? r : l) + cur.get(j);
			}
		}

		return dp[0][0];
	}
}
