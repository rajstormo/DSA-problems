import java.util.LinkedList;
import java.util.Queue;

// MaxDepth: number of nodes from the root to the leaf node
public class MaxDepth {

  /*
   * Approach1: level order traversal
   * depth is nothing but the just the count of levels(starting from 0)
   * while doing level order traversal, keep counting the levels covered 
   * finally, return levelCount+1;
   */
  public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        int level = -1;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode temp = q.remove();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                size--;
            }
            level++;
        }
        return level+1;
    }

    /*
     * Approach 2: apply DFS
     * return 1 + Math.max(leftSubtree depth, rightSubtree depth)
     * 1 is basically counting the root node and then calling recursively for the left and right subtree
     * base case: if a null node is encountered, it has no depth, so return 0
    */
    public static int maxDepthDFS(TreeNode root) {
      if (root == null)
        return 0;
      
      int leftSubTreeDepth = maxDepthDFS(root.left);
      int rightSubTreeDepth = maxDepthDFS(root.right);
      return 1 + Math.max(leftSubTreeDepth, rightSubTreeDepth);
    }
  
}
