import java.util.ArrayList;
import java.util.List;

/**
 * @author jacken
 * @date 2021/1/2 2:13 PM
 */
public class Combine {

  // 1. 每个位置选择加入或者不加入
  // 2. 下一层从上一层的起始位置 + 1
   public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> resultList = new ArrayList<>();
       List<Integer> list = new ArrayList<>();

       dfs(n, k, 1, list, resultList);
       return resultList;
   }

   private void dfs(int n, int k, int index, List<Integer> list, List<List<Integer>> resultList) {
       if (list.size() == k) {
           resultList.add(new ArrayList<>(list));
           return;
       }

       if (index > n) {
           return;
       }
       // 剩余元素都加入不足以构成一个满足集合，不需要在进行递归
       if (n - index + 1 < k - list.size()) {
           return;
       }

       // 不加入当前元素
       dfs(n, k, index + 1, list, resultList);

       // 加入当前元素
       list.add(index);
       dfs(n, k, index+1, list, resultList);
       list.remove(list.size()-1);
   }

//  public List<List<Integer>> combine(int n, int k) {
//    List<List<Integer>> resultList = new ArrayList<>();
//    List<Integer> list = new ArrayList<>();
//
//    boolean[] visited = new boolean[n];
//    recur(n, k, 1, list, resultList);
//    return resultList;
//  }
//
//  private void recur(int n, int k, int begin, List<Integer> list, List<List<Integer>> resultList) {
//    if (list.size() == k) {
//      resultList.add(new ArrayList(list));
//      return;
//    }
//
//    for (int i = begin; i <= n - (k - list.size()) + 1; i++) {
//      list.add(i);
//      recur(n, k, i+1, list, resultList);
//      list.remove(list.size()-1);
//    }
//  }
}
