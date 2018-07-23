package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static ArrayList<Integer> toArray(TreeNode node) {
		ArrayList<Integer> arrList = new ArrayList<>();
		return toArrayHelper(node, arrList, 0);
	}

	private static ArrayList<Integer> toArrayHelper(TreeNode node, ArrayList<Integer> arrList, int i) {
		if (node == null) {
			return null;
		}
		toArrayHelper(node.left, arrList, 2 * i + 1);
		while (arrList.size() <= i) {
			arrList.add(null);
		}
		arrList.set(i, node.val);
		toArrayHelper(node.right, arrList, 2 * i + 2);

		return arrList;
	}

	static void printPreorder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	static void printInorder(TreeNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	static void printPostorder(TreeNode node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.val + " ");
	}

	static void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			 System.out.print(tempNode.val + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
	
	static void printLevelOrder2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty()) {
			if (Math.log(i) / Math.log(2) % 1 == 0) {
				System.out.println(Math.log(i) / Math.log(2));
				System.out.print("queue: ");
				for (TreeNode t : queue) {
					System.out.print(t.val + " ");
				}
				System.out.println();
			}
			TreeNode tempNode = queue.poll();
			// System.out.println("val: " + tempNode.val + " ");
			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
			i++;
		}
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetricHelper(root.left, root.right);
	}

	public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		return left.val == right.val && isSymmetricHelper(left.left, right.right)
				&& isSymmetricHelper(left.right, right.left);
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(2);
		p.left.left = new TreeNode(3);
		p.left.right = new TreeNode(4);
		p.right.left = new TreeNode(4);
		p.right.right = new TreeNode(3);
		
		p.left.left.left = new TreeNode(1);
		p.left.left.right = new TreeNode(2);
		p.left.right.left = new TreeNode(3);
		p.left.right.right = new TreeNode(4);
		p.right.left.left = new TreeNode(4);
		p.right.left.right = new TreeNode(3);
		p.right.right.left = new TreeNode(2);
		p.right.right.right = new TreeNode(1);
		// TreeNode p = new TreeNode(1);
		// p.left = new TreeNode(2);
		// p.right = new TreeNode(3);
		// p.left.left = new TreeNode(4);
		// p.left.right = new TreeNode(5);
		// p.right.left = new TreeNode(6);
		// p.right.right = new TreeNode(7);
//		System.out.println(isSymmetric2(p));
//		System.out.println("\nlevel order:");
		printLevelOrder(p);
	}

}
