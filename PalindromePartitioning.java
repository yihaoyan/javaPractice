package com.yihao.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/palindrome-partitioning/
 * 
 * @author yanyihao
 *
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> current = new ArrayList<>();
		compute(s, current, 0, s.length(), result);
		return result;
	}

	public void compute(String str, List<String> current, int index, int len,
			List<List<String>> result) {
		if (index >= len) {
			List<String> newList = new ArrayList<>();
			for (String s : current) {
				newList.add(s);
			}
			result.add(newList);
		}
		
		for(int l = 1; l <=len - index; l++){
			if(isPalindrome(str, index, index+l-1)){
				current.add(str.substring(index, index+l));
				compute(str, current, index+l, len, result);
				current.remove(current.size()-1);
			}
		}
	}

	public boolean isPalindrome(String str, int begin, int end) {
		for (int i = begin; i <= (begin + end) / 2; i++) {
			if (str.charAt(i) != str.charAt(end - (i - begin))) {
				return false;
			}
		}
		return true;
	}
}
