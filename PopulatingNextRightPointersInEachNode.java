package com.yihao.test;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<>();
		int count = 0;
		int flag = 1;
		int incre = 1;
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeLinkNode cur = queue.poll();
			count++;
			if (count == flag) {
				cur.next = null;
				incre = incre << 1;
				flag += incre;
			} else {
				cur.next = queue.peek();
			}
			TreeLinkNode left = cur.left;
			if (left != null) {
				queue.add(left);
				queue.add(cur.right);
			}
		}
	}
}

class TreeLinkNode {
	public int val;
	public TreeLinkNode left, right, next;
	public TreeLinkNode(int x) {
		val = x;
	}
}
