package com.yihao.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Link: https://leetcode.com/problems/word-ladder/
 * 
 * @author yanyihao
 *
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		if (beginWord == endWord)
			return 1;

		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		int level = 1;
		queue.add(beginWord);
		queue.add(null);
		visited.add(beginWord);

		while (!queue.isEmpty()) {
			String cur = queue.poll();

			if (cur != null) {
				int len = cur.length();
				char[] str = cur.toCharArray();
				for (int i = 0; i < len; i++) {
					for (char j = 'a'; j <= 'z'; j++) {
						if (str[i] != j) {
							char temp = str[i];
							str[i] = j;

							String tempStr = new String(str);
							if (tempStr.equals(endWord))
								return level + 1;
							if (wordList.contains(tempStr)
									&& !visited.contains(tempStr)) {
								queue.add(tempStr);
								visited.add(tempStr);
							}
							str[i] = temp;
						}
					}
				}

			} else {
				level++;
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return 0;
	}
}
