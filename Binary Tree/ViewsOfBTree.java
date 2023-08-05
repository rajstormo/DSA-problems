import java.util.*;

public class ViewsOfBTree {

  static void topView(TreeNode root) {
    // queue<node, distance> 
    Queue<Pair> q = new LinkedList<>();
    // map<distance, node_value>
    Map<Integer, Integer> mp = new TreeMap<>();
    q.add(new Pair(root, 0));

    while (!q.isEmpty()) {
      Pair temp = q.remove();
      int dist = temp.num;

      if (!mp.containsKey(dist))
        mp.put(dist, temp.node.data);
      
      if (temp.node.left != null)
        q.add(new Pair(temp.node.left, dist-1));
      
      if (temp.node.right != null)
        q.add(new Pair(temp.node.right, dist+1));
    }

    for (Integer key : mp.keySet()) {
      System.out.print(mp.get(key) + " ");
    }
  }

  static void topViewDFS(TreeNode root, int dist, Map<Integer, Integer> mp) {
    if (root == null)
      return;
    
    if (!mp.containsKey(dist))
      mp.put(dist, root.data);
    
    topViewDFS(root.left, dist-1, mp);
    topViewDFS(root.right, dist+1, mp);
  }

  public static void main(String[] args) {
    // TreeNode root = new TreeNode(1);
    // root = root.createTree(new int[]{5,7,11,15,12,10});

    // Traversals.levelOrderTraversal(root);

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    
    root.left.left= new TreeNode(4);
    root.left.right= new TreeNode(5);
    root.left.right.left= new TreeNode(6);

    root.right.right = new TreeNode(7);


    topView(root);
    Map<Integer, Integer> mp = new TreeMap<>();
    // topViewDFS(root, 0, mp);
    for (Integer key : mp.keySet()) {
      System.out.print(mp.get(key) + " ");
    }
  }
}
