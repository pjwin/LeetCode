package leetcode;

import java.util.List;
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

	TreeNode() {
	}

	TreeNode(int x) {
		val = x;
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(6);
		p.left.left = new TreeNode(3);
		p.left.left.left = new TreeNode(4);
		p.left.left.left.left = new TreeNode(5);
		System.out.println(levelOrderBottom(p));
//		delete(p, 4);
		System.out.println();
	}

	public static int maxDepth(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	static void insert(TreeNode temp, int key) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(temp);

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.left == null) {
				temp.left = new TreeNode(key);
				break;
			} else {
				q.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = new TreeNode(key);
				break;
			} else {
				q.add(temp.right);
			}
		}
	}
	
	static void delete(TreeNode node, int key) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		TreeNode tempNode = null;
		TreeNode keyNode = null;
		TreeNode prevNode = null; 
		while (!queue.isEmpty()) {
			prevNode = tempNode;
			tempNode = queue.poll();
			if (tempNode.val == key) {
				keyNode = tempNode;
			}
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
		keyNode.val = tempNode.val;
		//delete tempnode
		
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

	static void printLevelOrder(TreeNode node) {
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

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(root == null) return result;
	    Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    while(q.size() > 0){
	        List<Integer> list = new LinkedList<>();
	        int size = q.size();
	        for(int i = 0; i < size; i++){
	            TreeNode node = q.poll();
	            list.add(node.val);
	            if(node.left != null) {
	            	q.add(node.left);
	            }
	            if(node.right != null) {
	            	q.add(node.right);
	            }
	        }
	        result.add(0, list);
	    }
	    return result;
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

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
