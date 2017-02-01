package com.yihao.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * if num1 is a prefix of num2, remove the prefix(num1) from num2
 * 
 * keep doing that until num1 and num2 are not prefix of each other
 * 
 * then compare num1 and num2.
 * 
 * Link: https://leetcode.com/problems/largest-number/
 * 
 * @author yanyihao
 *
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		List<StringObj> strNums = new ArrayList<>();
		int len = nums.length;

		for (int i = 0; i < len; i++) {
			strNums.add(new StringObj(nums[i]));
		}
		Collections.sort(strNums);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			// System.out.println(strNums.get(i).toString());
			sb.append(strNums.get(i).data);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

}

class StringObj implements Comparable<StringObj> {
	public String data;

	public StringObj(int data) {
		this.data = data + "";
	}

	@Override
	public int compareTo(StringObj o) {
		String s = data;
		String str = o.data;
		int len1 = s.length();
		int len2 = str.length();

		if (len1 == len2) {
			return str.compareTo(s);
		} else {
			while ((((len1 = s.length()) > (len2 = str.length())
					&& prefix(s, str)) || (len2 > len1 && prefix(str, s)))
					&& len1 != 0 && len2 != 0) {

				if (len1 > len2 && prefix(s, str)) {
					s = s.substring(len2, len1);
				}

				if (len2 > len1 && prefix(str, s)) {
					str = str.substring(len1, len2);
				}
			}

			if (len1 == 0 || len2 == 0)
				return 0;
			else {
				return str.compareTo(s);
			}
		}
	}

	private boolean prefix(String str1, String str2) {
		int len2 = str2.length();

		String pre = str1.substring(0, len2);
		if (pre.equals(str2)) {
			return true;
		} else {
			return false;
		}
	}
}
