import java.util.ArrayList;
import java.util.List;

/**
 * @author jacken
 * @date 2020/12/31 11:11 PM
 */
public class NQueens {

  // 回溯递归
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> resultList = new ArrayList<>();
    List<String> list = new ArrayList<>();
    if (n <= 0) {
      resultList.add(list);
      return resultList;
    }

    recur(0, n, resultList, list);
    return resultList;
  }

  private void recur(int row, int n, List<List<String>> resultList, List<String> list) {
    if (row == n) {
      resultList.add(new ArrayList(list));
      return;
    }

    for (int column = 0; column < n; column++) {
      if (isSatisfy(row, column, n, list)) {
        String queenStr = getQueenStr(n, column);
        list.add(queenStr);
        recur(row + 1, n, resultList, list);
        list.remove(list.size() - 1);
      }
    }
  }

  // 对角线的各自坐标计算公式row+column相等或者row-column相等
  private boolean isSatisfy(int row, int column, int n, List<String> list) {
    for (int i = 0; i < row; i++) {
      String str = list.get(i);
      for (int j = 0; j < n; j++) {
        char c = str.charAt(j);
        // 对角线或者是同一列存在Queen则返回
        if (c == 'Q' && (row - column == i - j || row + column == j + i || column == j))
          return false;
      }
    }
    return true;
  }

  private String getQueenStr(int n, int index) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i == index) {
        sb.append("Q");
      } else {
        sb.append(".");
      }
    }
    return sb.toString();
  }
}
