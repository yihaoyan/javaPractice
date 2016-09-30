package com.yihao.test;

import java.util.LinkedList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/permutation-sequence/
 * @author yanyihao
 *
 */
public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		if(n == 1)
			return "1";
		
        StringBuffer sb = new StringBuffer();
        List<String> nums = new LinkedList<>();
        int factor = 1;
        for(int i=1; i<=n; i++){
        	nums.add(i+"");
        	factor *= i;
        }
        factor /= n;
        int temp = k;
        int c = n-1;
        while(temp > 0 && c > 0){
        	int t = (temp-1) / factor;
        	
        	if(t != 0){
        		sb.append(nums.remove(t));
        		temp -= factor * t;
        	}else{
        		sb.append(nums.remove(0));
        	}
        	factor /= c;
        	c--;
        }
        
        sb.append(nums.remove(0));
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(getPermutation(3, 1));
		System.out.println(getPermutation(3, 2));
		System.out.println(getPermutation(3, 3));
		System.out.println(getPermutation(3, 4));
		System.out.println(getPermutation(3, 5));
		System.out.println(getPermutation(3, 6));
	}
}
