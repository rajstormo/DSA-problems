import java.util.*;


public class Main {   
        
    public static boolean isFull(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.right == null || root.left == null && root.right != null)
            return false;
        
        return isFull(root.left) && isFull(root.right);
    }
    
    public static boolean isComplete(TreeNode root) {
        if (root == null)
            return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (true) {
            root = q.remove();
            while (q.peek() == null) {
                q.remove();
                if (q.isEmpty())
                    return true;
                return false;
            }
            
            q.add(root.left);
            q.add(root.right);
        }
    }
    
    public static boolean isPerfect(TreeNode root) {
        if (root == null)
            return true;
        
        if (root.left == null && root.right == null)
            return true;
        
        if (root.left == null && root.right != null || root.left != null && root.right == null)
            return false;
        
        return isPerfect(root.left) && isPerfect(root.right);
        
    }
    
    // public static ArrayList<Integer> removeLeaves(TreeNode root);
    
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8};
        TreeNode root = new TreeNode(1);
        root = root.createTree(arr);
        
        Traversals.levelOrderTraversal(root);
	}
}
