import java.util.HashMap;
import java.util.Map;

/**
 * @author jacken
 * @date 2021/1/2 3:04 PM
 */
public class BuildTree {

  Map<Integer, Integer> indexMap = new HashMap<>();

  // 左右子树递归，根据前序遍历得到根节点，中序遍历当前根节点的左右子树
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      indexMap.put(inorder[i], i);
    }

    return buildTreeRecur(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode buildTreeRecur(int[]preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
    if (preorderLeft > preorderRight) {
      return null;
    }

    int rootValue = preorder[preorderLeft];
    int inorderRootIndex = indexMap.get(rootValue);

    // 构造根节点
    TreeNode root = new TreeNode(inorder[inorderRootIndex]);

    int preorderLeftTreeSize = inorderRootIndex - inorderLeft;

    // 遍历构造左右子树
    root.left = buildTreeRecur(preorder, inorder, preorderLeft + 1, preorderLeft + preorderLeftTreeSize, inorderLeft, inorderRootIndex - 1);
    root.right = buildTreeRecur(preorder, inorder,  preorderLeft + preorderLeftTreeSize + 1, preorderRight, inorderRootIndex + 1, inorderRight);
    return root;
  }

}
