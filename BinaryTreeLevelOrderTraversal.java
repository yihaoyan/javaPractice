package com.yihao.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author yanyihao
 *
 */
public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		compute(root, 0, result);
		return result;
	}

	public void compute(TreeNode node, int level, List<List<Integer>> result) {
		if (node == null)
			return;
		if (result.size() <= level) {
			result.add(new ArrayList<Integer>());

		}
		result.get(level).add(node.val);
		compute(node.left, level + 1, result);
		compute(node.right, level + 1, result);
	}

	class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
