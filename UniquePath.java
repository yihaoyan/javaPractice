package com.yihao.test;

/**
 * Link: https://leetcode.com/submissions/detail/76451731/
 * @author yanyihao
 *
 */
public class UniquePath {
	public int uniquePaths(int m, int n) {
        //int result = 0;
        int[][] result = new int[m][n];
        
        for(int i=m-1; i>=0; i--){
        	for(int j=n-1; j>=0; j--){
        		if(i == m-1 && j == n-1)
        			result[i][j] = 1;
        		else if(j + 1 < n){
        			result[i][j] += result[i][j+1];
        		}else if(i + 1 < m){
        			result[i][j] += result[i+1][j];
        		}
        	}
        }
        return result[0][0];
    }
}
