package leetcode;

import java.util.ArrayList;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static boolean isSameTreeOld(TreeNode p, TreeNode q) {
		ArrayList<Integer> plist = toArray(p);
		ArrayList<Integer> qlist = toArray(q);
		return plist == null && qlist == null ? true : (plist == null || qlist == null ?  false : plist.equals(qlist));
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

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
//		p.left.right = new TreeNode(4);
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);
		System.out.println(isSameTree(p, q));
		System.out.println(isSameTree(null, null));
		
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

}
