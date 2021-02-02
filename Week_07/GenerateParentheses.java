import java.util.ArrayList;
import java.util.List;

/**
 * @author jacken
 * @date 2021/2/2 11:07 PM
 */
public class GenerateParentheses {

  // dfs加上剪枝条件：1.左括号小于n可以加入 2.右括号小于左括号可以加入
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    generate(n, 0, 0, "", list);
    return list;
  }

  private void generate(int n, int left, int right, String str, List<String> list) {
    if (left == n && right == n) {
      list.add(str);
      return;
    }

    if (left < n) {
      generate(n, left+1, right, str + "(", list);
    }
    if (right < left) {
      generate(n, left, right+1, str + ")", list);
    }
  }
}
