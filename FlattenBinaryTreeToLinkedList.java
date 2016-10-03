package com.yihao.test;

/**
 * Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * @author yanyihao
 *
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.left);
		flatten(root.right);

		TreeNode left = root.left;
		TreeNode right = root.right;

		if (left == null) {
			return;
		} else {
			TreeNode temp = left;
			
			while (temp.right != null)
				temp = temp.right;
			temp.right = right;
			root.right = left;
			root.left = null;
		}
	}
}
