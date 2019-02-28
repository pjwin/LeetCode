package leetcode;

public class TreeTest {

	public static void main(String[] args) {

//		[3, 9, 20, null, null, 15, 7]
//		TreeNode p1 = new TreeNode(3);
//		p1.left = new TreeNode(9);
//		p1.right = new TreeNode(20);
//		p1.right.left = new TreeNode(15);
//		p1.right.right = new TreeNode(7);
		
//		[5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1]
		TreeNode p2 = new TreeNode(5);
		p2.left = new TreeNode(4);
		p2.right = new TreeNode(8);
		p2.left.left = new TreeNode(11);
//		p2.left.right = new TreeNode(3);
		p2.right.left = new TreeNode(13);
		p2.right.right = new TreeNode(4);
		p2.left.left.left = new TreeNode(7);
		p2.left.left.right = new TreeNode(2);
//		p2.left.right.left = new TreeNode(4);
//		p2.left.right.right = new TreeNode(4);
//		p2.right.left.left = new TreeNode(4);
//		p2.right.left.right = new TreeNode(1);
//		p2.right.right.left = new TreeNode(1);
		p2.right.right.right = new TreeNode(1);
//		p2.left.left.left.left = new TreeNode(5);
//		p2.left.left.left.right = new TreeNode(5);
		p2.printTree();
		System.out.println(p2.hasPathSum(p2, 22));
//		System.out.println(p2.isBalanced(p2));

//		[3,9,20,null,null,15,7]
//		TreeNode p3 = new TreeNode(3);
//		p3.left = new TreeNode(9);
//		p3.right = new TreeNode(20);
//		p3.right.left = new TreeNode(15);
//		p3.right.right = new TreeNode(7);
//		System.out.println(p3.minDepth(p3));

//		[1,2]
		TreeNode p4 = new TreeNode(1);
		p4.left = new TreeNode(2);
		p4.printTree();
		System.out.println(p4.hasPathSum(p4, 1));
		
//		[-2, null, -3]
		TreeNode p5 = new TreeNode(-2);
		p5.right = new TreeNode(-3);
		p5.printTree();
		System.out.println(p5.hasPathSum(p5, -5));
		
//		[1,-2,-3,1,3,-2,null,-1]
		TreeNode p6 = new TreeNode(1);
		p6.left = new TreeNode(-2);
		p6.right = new TreeNode(-3);
		p6.left.left = new TreeNode(1);
		p6.left.right = new TreeNode(3);
		p6.right.right = new TreeNode(-1);
		p6.printTree();
		System.out.println(p6.hasPathSum(p6, 2));
	}

}
