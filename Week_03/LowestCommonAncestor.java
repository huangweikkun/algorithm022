/**
 * @author jacken
 * @date 2021/1/1 10:39 AM
 */
public class LowestCommonAncestor {

  // 分治 O(n)
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    // 左为空，返回右节点，右节点为空，返回左节点，左右都不为空返回当前节点
    return left == null ? right : right == null ? left : root;
  }
}
