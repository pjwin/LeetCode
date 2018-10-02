package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		// TODO
		return null;
	}

	public void insert(int key) {
		TreeNode node = this;
		while (node != null && node.val != key) {
			if (key < node.val) {
				if (node.left == null) {
					node.left = new TreeNode(key);
					node = null;
				} else {
					node = node.left;
				}
			} else if (key > node.val) {
				if (node.right == null) {
					node.right = new TreeNode(key);
					node = null;
				} else {
					node = node.right;
				}
			}
		}
	}

	public boolean delete(int key) {
		// TODO
		return false;
	}

	public TreeNode search(int key) {
		TreeNode node = this;
		while (node != null && node.val != key) {
			if (key < node.val) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}

	public int maxDepth(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	public TreeNode min() {
		TreeNode node = this;
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public TreeNode max() {
		TreeNode node = this;
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	public ArrayList<Integer> toArray(TreeNode node) {
		ArrayList<Integer> arrList = new ArrayList<>();
		return toArrayHelper(node, arrList, 0);
	}

	private ArrayList<Integer> toArrayHelper(TreeNode node, ArrayList<Integer> arrList, int i) {
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

	public void printPreorder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	public void printInorder(TreeNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	public void printPostorder(TreeNode node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.val + " ");
	}

	public void printLevelOrder(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
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

	public void printTree() {
		TreeNode root = this;
		List<List<String>> result = new ArrayList<List<String>>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		result.add(0, Arrays.asList(String.valueOf(q.peek().val)));
		while (q.size() > 0) {
			List<String> list = new LinkedList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.add(node.left);
					list.add(String.valueOf(node.left.val));
				} else {
					list.add("null");
				}
				if (node.right != null) {
					q.add(node.right);
					list.add(String.valueOf(node.right.val));
				} else {
					list.add("null");
				}

			}
			if (!list.stream().allMatch(i -> i.equalsIgnoreCase("null"))) {
				result.add(list);
			}
		}
		for (List<String> l : result) {
			System.out.println(l);
		}
	}

	public static List<List<String>> levelOrderBottom(TreeNode root) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			List<String> list = new LinkedList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				list.add(String.valueOf(node.val));
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}

			}
			result.add(0, list);
		}
		return result;
	}
	
	public boolean isSymmetric() {
		return isSymmetricHelper(this.left, this.right);
	}

	public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		return left.val == right.val && isSymmetricHelper(left.left, right.right)
				&& isSymmetricHelper(left.right, right.left);
	}
	
	public boolean isSameTree(TreeNode q) {
		return isSameTree(this, q);
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
