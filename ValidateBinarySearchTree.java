package com.yihao.test;
/**
 * Link: https://leetcode.com/problems/validate-binary-search-tree/
 * @author yanyihao
 *
 */
public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		boolean vLeft = isValidBST(root.left);

		if (!vLeft)
			return false;
		boolean vRight = isValidBST(root.right);

		if (!vRight)
			return false;
		int val = root.val;

		if (root.right != null) {
			TreeNode temp = root.right;
			
			while (temp.left != null)
				temp = temp.left;
			if (val >= temp.val)
				return false;
		}
		if (root.left != null) {
			TreeNode temp = root.left;
			
			while (temp.right != null)
				temp = temp.right;
			if (val <= temp.val)
				return false;
		}
		return true;
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
