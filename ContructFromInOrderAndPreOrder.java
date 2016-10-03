package com.yihao.test;

/**
 * preorder records the information about root node of each subtree, inorder
 * records information about what on the left/right of a given node.
 * 
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author yanyihao
 *
 */
public class ContructFromInOrderAndPreOrder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len1 = preorder.length;
		int len2 = inorder.length;

		return construct(preorder, inorder, 0, 0, len2 - 1, len1, len2);
	}

	public TreeNode construct(int[] preorder, int[] inorder, int preIndex, int inIndex1, int inIndex2, int size1,
			int size2) {
		if (inIndex2 < inIndex1 || preIndex >= size1 || inIndex2 >= size2)
			return null;
		if (inIndex1 == inIndex2) {
			return new TreeNode(preorder[preIndex]);
		}
		int value = preorder[preIndex];
		int index = inIndex1;

		while (inorder[index] != value) {
			index++;
		}
		TreeNode result = new TreeNode(value);

		result.left = construct(preorder, inorder, preIndex + 1, inIndex1, index - 1, size1, size2);
		result.right = construct(preorder, inorder, preIndex + index - inIndex1 + 1, index + 1, inIndex2, size1, size2);

		return result;
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
