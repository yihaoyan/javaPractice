package com.yihao.test;

/**
 * Link: https://leetcode.com/problems/unique-binary-search-trees/
 * @author yanyihao
 *
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n < 2) return 1;
		if(n == 2) return 2;
		int[] result = new int[n+1];
		
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		for(int i=3; i<=n; i++){
			for(int j=0; j<i; j++){
				result[i] += result[j] * result[i-1-j];
			}
		}
        return result[n];
    }
}
