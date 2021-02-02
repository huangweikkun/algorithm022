/**
 * @author jacken
 * @date 2021/2/2 9:45 PM
 */
public class NumberOfIsland {

  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    UnionFind unionFind = new UnionFind(m * n);
    int[][] directions = {{0,1}, {1, 0}};
    int space = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '0') {
          space ++;
        } else {
          for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            if (newRow < m && newCol < n && grid[newRow][newCol] == '1') {
              unionFind.union(getIndex(i, j, n), getIndex(newRow, newCol, n));
            }
          }
        }
      }
    }

    return unionFind.count - space;
  }

  private int getIndex(int i, int j, int cols) {
    return i * cols + j;
  }

  class UnionFind {

    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public int find(int p) {
      while (p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) {
        return;
      }
      parent[rootP] = rootQ;
      count--;
    }
  }

  /**
   * 1. dfs O(n) 2. 并查集 O(n)
   */
  public int numIslandsDFS(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int nums = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          nums++;
          dfs(grid, i, j);
        }
      }
    }

    return nums;
  }

  private void dfs(char[][] grid, int i, int j) {
    if (grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';
    if (i - 1 >= 0) {
      dfs(grid, i - 1, j);
    }
    if (j - 1 >= 0) {
      dfs(grid, i, j - 1);
    }
    if (j + 1 < grid[0].length) {
      dfs(grid, i, j + 1);
    }
    if (i + 1 < grid.length) {
      dfs(grid, i + 1, j);
    }
  }
}
