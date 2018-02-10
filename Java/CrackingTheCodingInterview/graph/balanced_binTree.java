/**
	检验一棵树是否是一个平衡二叉树
*/
public static int maxDepth(TreeNode root){
	if (root == null){
		return 0;
	}
	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}

public static int minDepth(TreeNode root){
	if (root == null){
		return 0;
	}
	return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}

public static boolean isBalanced(TreeNode root){
	return (maxDepth(root) - minDepth(root) <= 1);
}
