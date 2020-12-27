import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jacken
 * @date 2020/12/27 5:38 PM
 */
public class BinaryTreeInOrderTraversal {

  // 1. 递归
  // 2. 迭代
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      list.add(root.val);
      root = root.right;
    }
    return list;
  }

  // public List<Integer> inorderTraversal(TreeNode root) {
  //     List<Integer> list = new LinkedList<>();
  //     helper(root, list);
  //     return list;
  // }

  private void helper(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    helper(root.left, list);
    list.add(root.val);
    helper(root.right, list);
  }
}
