#### 并查集

代码实现
```
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
```


#### Trie树

代码实现
```
public class Trie {

  private TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.get(c) == null) {
        node.put(c);
      }
      node = node.get(c);
    }
    node.setEnd();
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode trieNode = searchPrefix(word);
    return trieNode != null && trieNode.getEnd();
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode trieNode = searchPrefix(prefix);
    return trieNode != null;
  }

  public TrieNode searchPrefix(String prefix) {
    TrieNode node = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (node.get(c) == null) {
        return null;
      }
      node = node.get(c);
    }

    return node;
  }

  public static class TrieNode {

    private static final int R = 26;

    private TrieNode[] children;

    private boolean isEnd;

    public TrieNode() {
      children = new TrieNode[R];
    }

    public void put(char c) {
      if (children[c - 'a'] == null) {
        children[c - 'a'] = new TrieNode();
      }
    }

    public TrieNode get(char c) {
      return children[c - 'a'];
    }

    public void setEnd() {
      this.isEnd = true;
    }

    public boolean getEnd() {
      return this.isEnd;
    }
  }
}
```
