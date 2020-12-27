import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreOrderTraversal {
    // 递归 On
    // 迭代 On
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return list;
        // helper(root, list);
        // return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

}