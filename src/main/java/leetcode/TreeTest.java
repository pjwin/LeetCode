package leetcode;

public class TreeTest {

	public static void main(String[] args) {
//		TreeNode p = new TreeNode(5);
//		p.insert(3);
//		p.insert(4);
//		p.insert(7);
//		p.insert(10);
//		p.insert(11);
//		p.insert(12);
//		p.printTree();
		
//		p.insert2(3);
//		TreeNode t = p.search2(11);

//		TreeNode p1 = TreeNode.sortedArrayToBST3(new int[] {-10,-3,0,5,9});
//		p1.printTree();
//		System.out.println();
//		TreeNode p2 = TreeNode.sortedArrayToBST3(new int[] {0,1,2,3,4,5});
//		p2.printTree();
//		System.out.println(t.val);
//		TreeNode p1 = new TreeNode(3);
//		p1.left = new TreeNode(9);
//		p1.right = new TreeNode(20);
//		p1.right.left = new TreeNode(15);
//		p1.right.right = new TreeNode(7);
		
//		[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]
//		TreeNode p2 = new TreeNode(1);
//		p2.left = new TreeNode(2);
//		p2.right = new TreeNode(2);
//		p2.left.left = new TreeNode(3);
//		p2.left.right = new TreeNode(3);
//		p2.right.left = new TreeNode(3);
//		p2.right.right = new TreeNode(3);
//		p2.left.left.left = new TreeNode(4);
//		p2.left.left.right = new TreeNode(4);
//		p2.left.right.left = new TreeNode(4);
//		p2.left.right.right = new TreeNode(4);
//		p2.right.left.left = new TreeNode(4);
//		p2.right.left.right = new TreeNode(4);
//		p2.left.left.left.left = new TreeNode(5);
//		p2.left.left.left.right = new TreeNode(5);
//		p2.printTree();
//		System.out.println(p2.isBalanced(p2));
//		[3,9,20,null,null,15,7]
//		[1,2]
		TreeNode p4 = new TreeNode(3);
		p4.left = new TreeNode(9);
		p4.right = new TreeNode(20);
		p4.right.left = new TreeNode(15);
		p4.right.right = new TreeNode(7);
		System.out.println(p4.minDepth(p4));
		TreeNode p5 = new TreeNode(1);
		p5.left = new TreeNode(2);
		System.out.println(p5.minDepth(p5));
	}

}
