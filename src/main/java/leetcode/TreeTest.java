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

		TreeNode p1 = TreeNode.sortedArrayToBST3(new int[] {-10,-3,0,5,9});
		p1.printTree();
		System.out.println();
		TreeNode p2 = TreeNode.sortedArrayToBST3(new int[] {0,1,2,3,4,5});
		p2.printTree();
//		System.out.println(t.val);

	}

}
