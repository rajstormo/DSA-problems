import java.util.*;

public class TypesOfTree {
  // either 0 or 2 child
  /*
   * Approach: for each node check whether it has only one child, if it has ->
   * return false, otherwise true
   */
  public static boolean isFullBinaryTree(TreeNode root) {
    if (root == null)
      return true;

    // check if node has exactly one child
    if (root.left == null && root.right != null || root.left != null && root.right == null)
      return false;

    boolean leftSubTree = isFullBinaryTree(root.left);
    boolean rightSubTree = isFullBinaryTree(root.right);

    return (leftSubTree && rightSubTree);
  }

  /*
   * def: n-1 level -> completely filled, last level -> filled from left to right
   * Approach
   * if any node exists after finding a null node -> it means it is not a complete
   * tree
   */
  public static boolean isComplete(TreeNode root) {
    if (root == null)
      return true;
    Queue<TreeNode> q = new LinkedList<>();
    boolean isNullNodeFound = false;
    q.add(root);

    while (!q.isEmpty()) {
      TreeNode node = q.remove();

      // if curr node is not null and any Null node has been found previously, that
      // means it fails the criteria of being a complete binary tree
      if (node != null) {
        if (isNullNodeFound)
          return false;
        q.add(node.left);
        q.add(node.right);
      }
      // if it is null, set nullNodeFound to true
      else {
        isNullNodeFound = true;
      }
    }
    return true;
  }

  // def: exactly 2 nodes & all leaf nodes at same level
  public static boolean isPerfect() {
    return true;
  }

  public static void main(String args[]) {

    int arr[] = { 5, 7, 11, 15, 12, 10 };
    TreeNode root = new TreeNode(1);
    root = root.createTree(arr);

    System.out.println(isFullBinaryTree(root));
    System.out.println(isComplete(root));
  }
}
