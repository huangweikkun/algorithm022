学习笔记

#### 不同路径II递推公式
```
dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1]
```

#### 动态规划解题思路

1. 定义dp数组，一般是一维和二维
2. 推导出数组中的状态转移方程
3. 初始化数组的初始状态

#### 字符串匹配算法

字符串的算法优化是在暴力匹配的基础上进行优化

1. 暴力匹配：对于匹配串的每个字母开始进行比较
```java
public static int forceSearch(String txt, String pat) {
    int M = txt.length();
    int N = pat.length();
    for (int i = 0; i <= M - N; i++) {
      int j;
      for (j = 0; j < N; j++) {
        if (txt.charAt(i + j) != pat.charAt(j)) {
          break;
        }
      }
      if (j == N) {
        return i;
      }
    }
    return -1;
  }
```
2. Rabin-Karp: 对于每个子串的比较匹配先比较子串和匹配串hash值，若相等在进行逐个字符比较，采用的hash算法需要可以扣减和增加字符计算

```java
public final static int D = 256;
  public final static int Q = 9997;

  static int RabinKarpSerach(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;
    for (i = 0; i < M; i++) {
      patHash = (D * patHash + pat.charAt(i)) % Q;
      txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }
    int highestPow = 1;
    pow(256, M - 1);
    for (i = 0; i < M - 1; i++) {
      highestPow = (highestPow * D) % Q;
    }
    for (i = 0; i <= N - M;
        i++) {
      // 枚举起点       
      if (patHash == txtHash) {
        for (j = 0; j < M; j++) {
          if (txt.charAt(i + j) != pat.charAt(j)) {
            break;
          }
        }
        if (j == M) {
          return i;
        }
      }
      if (i < N - M) {
        txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
        if (txtHash < 0) {
          txtHash += Q;
        }
      }
    }
    return -1;
  }
```

3. KMP算法：使用前缀表减少比较的次数，首先算出匹配串的最长相等前后缀的匹配表，在匹配过程中遇到不匹配的字符时，获取前面子串的最长相等前后缀的长度，然后将匹配串的最长相等前后缀的长度
下标的字符移动到当前原串不匹配的字符串的位置，从不匹配的位置重新开始进行匹配，循环这样子的操作指导找到匹配的子串。
