import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.List;

public class Traversals {
  // creating a perfect binary with given arr
  static TreeNode createTree(int arr[], TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    if (root == null) {
      TreeNode newNode = new TreeNode(arr[0]);
      root = newNode;
    }

    q.add(root);

    int i = 1;
    while (i < arr.length && !q.isEmpty()) {
      TreeNode node = q.remove();
      node.left = new TreeNode(arr[i++]);
      node.right = new TreeNode(arr[i++]);
      q.add(node.left);
      q.add(node.right);
    }

    return root;
  }

  // Q1: PREORDER RECURSIVE
  static void preorder(TreeNode root) {
    if (root == null)
      return;

    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  // Q2: PREORDER ITERATIVE
  /* IDEA
    * execute in PLR order
    * first print the root
    * now, take a stack and push the right child first and then the left child
    * this ensures that we keep moving the left child first i.e following PLR order 
   */
    
  static void preOrderIterative(TreeNode root) {
    if (root == null) {
      System.out.println("Empty tree");
      return;
    }

    Stack<TreeNode> st = new Stack<>();
    st.push(root);

    while (!st.isEmpty()) {
      TreeNode node = st.pop();
      System.out.print(node.data + " ");
      if (node.right != null)
        st.push(node.right);
      if (node.left != null)
        st.push(node.left);
    }
  }

  // Q3: INORDER ITERATIVE
  /* IDEA
    * idea is to reach the leftmost node and keep storing the nodes in a stack
    * while returning back, print the parent and then push the right child
    * so, LPR pattern is followed here 
   */
  
  static void inOrderIterative(TreeNode root) {
    if (root == null)
      return;
    Stack<TreeNode> st = new Stack<>();
    while (true) {
      if (root != null) {
        st.push(root);
        root = root.left;
      } else {
        if (st.isEmpty())
          break;
        root = st.pop();
        System.out.print(root.data + " ");
        root = root.right;
      }
    }
  }

  // Q4. LEVEL ORDER TRAVERSAL
  /*
   * IDEA
   * just take a queue and keep pushing the left and right child if they exist
   * then process them in the order they are stored in queue i.e level wise
   */
  
  static void levelOrderTraversal(TreeNode root) {
    if (root == null)
      return;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      root = q.remove();
      System.out.print(root.data + " ");
      if (root.left != null)
        q.add(root.left);
      if (root.right != null)
        q.add(root.right);
    }
  }

  // Q5. preorder, postorder & inorder in single traversal
    /*
    Algorithm 
      1. take of stack<Pair>, Pair contains a node and a value 'num'
      2. push (root,1) into the stack
      3. while stack is not empty
        4. if num is 1 -> this is for preorder (i.e parent must be executed first)
              first print the node's data
              then, push the same node with value of 2 i.e (node, 2)
              and, then also push the left child(if exists) with value 1 i.e (node.left, 1)

        5. if num is 2 -> this is for inorder (i.e parent is 2nd => LPR)
              first print node's data 
              push the same node with value 3 i.e (node,3)
              then, push right child if exists i.e (node.right, 1) 
        
        6. if num is 3 -> this is for postorder (i.e LRP)
              simply print node's data 
    */    
  static void allTraversal(TreeNode root) {
    if (root == null)
      return;
    List<Integer> preorder = new ArrayList<>();
    List<Integer> postorder = new ArrayList<>();
    List<Integer> inorder = new ArrayList<>();

    Stack<Pair> st = new Stack<>();
    st.push(new Pair(root, 1));

    while (!st.isEmpty()) {
      Pair temp = st.pop();
      switch (temp.num) {
        case 1:
          preorder.add(temp.node.data);
          st.push(new Pair(temp.node, ++temp.num));
          if (temp.node.left != null)
            st.push(new Pair(temp.node.left, 1));

          break;

        case 2:
          inorder.add(temp.node.data);
          st.push(new Pair(temp.node, ++temp.num));
          if (temp.node.right != null)
            st.push(new Pair(temp.node.right, 1));
          break;

        case 3:
          postorder.add(temp.node.data);
      }
    }
    System.out.println(preorder);
    System.out.println(inorder);
    System.out.println(postorder);

  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
    TreeNode root = null;
    root = createTree(arr, root);

    // preOrderIterative(root);
    // inOrderIterative(root);
    levelOrderTraversal(root);
    allTraversal(root);
  }
}