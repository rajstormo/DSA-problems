import java.util.*;

// structure of a Tree Node
public class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  
  public TreeNode(int data) {
    this.data = data;
    left = null;
    right = null;
  }

  // function to create a complete binary tree from given arr
  public TreeNode createTree(int arr[]) {
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode root = new TreeNode(arr[0]); 
    q.add(root);
    int i = 1;
    
    while (!q.isEmpty()) {
      TreeNode temp = q.remove();
      if (i < arr.length) {
        TreeNode newNode = new TreeNode(arr[i++]);
        q.add(newNode);
        temp.left = newNode;
      }
      if (i < arr.length) {
        TreeNode newNode = new TreeNode(arr[i++]);
        q.add(newNode);
        temp.right = newNode;
      }  
    }
    return root;
  }

}