import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePostOrderTraversal {

    // 递归 On
    // 迭代 On
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && node.left != pre && node.right != pre) {
                stack.push(node.left);
            } else if (node.right != null && node.right != pre) {
                stack.push(node.right);
            } else {
                list.add(node.val);
                pre = stack.pop();
            }
        }

        // helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }

}