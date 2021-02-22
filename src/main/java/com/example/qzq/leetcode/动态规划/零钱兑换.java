package com.example.qzq.leetcode.动态规划;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Date 2021/2/11 12:29
 * @Author by qiziqian
 */
public class 零钱兑换 {

    //    public static void main(String[] args) {
//        System.out.println(minOperations("0100"));
//        System.out.println(minOperations("10"));
//        System.out.println(minOperations("1111"));
//        System.out.println(minOperations("11111"));
//        System.out.println(minOperations("10010100"));
//
//    }
    public static int minOperations(String s) {
        char[] chars = s.toCharArray();
        char curr = '1';
        int res1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (curr != chars[i]) {
                res1++;
            }
            curr = curr == '0' ? '1' : '0';
        }
        curr = '0';
        int res2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (curr != chars[i]) {
                res2++;
            }
            curr = curr == '0' ? '1' : '0';
        }

        return Math.min(res1, res2);
    }

    //    public static void main(String[] args) {
//        System.out.println(countHomogenous("abbcccaa"));
//        System.out.println(countHomogenous("xy"));
//        System.out.println(countHomogenous("zzzzz"));
//    }
    public static int countHomogenous(String s) {
        long res = 0;
        int MOD = (int) (1e9 + 7);
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
            long len = j - i + 1;
            res += len * (len - 1) / 2;
            i = j - 1;
        }
        return (int) (res % MOD);
    }

    //    public static void main(String[] args) {
//        minTrioDegree(6
//               ,new int[][] {{1,2},{1,3},{3,2},{4,1},{5,2},{3,6}});
//    }
    public static int minTrioDegree(int n, int[][] edges) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int[] count = new int[n + 1];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a][b] = true;
            graph[b][a] = true;
            count[a]++;
            count[b]++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (graph[i][j] && graph[j][k] && graph[i][k]) {
                        ans = Math.min(ans, count[i] + count[k] + count[j] - 6);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return getMinCoinCount(coins, amount, new int[amount + 1]);
    }

    public int getMinCoinCount(int[] coins, int amount, int[] ints) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (ints[amount] != 0) {
            return ints[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = getMinCoinCount(coins, amount - coin, ints);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        ints[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return ints[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        int n = coins.length;

        int[] dp = new int[amount];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i < amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount - 1] == amount + 1) return -1;
        return dp[amount - 1];
    }

    public int change(int amount, int[] coins) {
        if (amount < 1) return 0;
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int[][] dp = new int[n][2001];
        dp[0][1000 + nums[0]] = 1;
        dp[0][1000 - nums[0]] += 1;
        for (int i = 0; i < n; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (dp[i][j] > 0) {
                    dp[i][j - nums[i] + 1000] += dp[i][j + 1000];
                    dp[i][j + nums[i] + 1000] += dp[i][j + 1000];
                }
            }
        }
        return dp[n - 1][S + 1000];
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= right) {
                right = Math.max(right, i + nums[i]);
            }

        }
        return right >= nums.length - 1;
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        UnionSet unionSet = new UnionSet(n / 2);
        for (int i = 0; i < n; i += 2) {
            unionSet.union(row[i] / 2, row[i + 1] / 2);
        }
        return unionSet.count;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int l = 0, r = 1000000000;
        int res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(nums, mid, maxOperations)) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private boolean check(int[] nums, int cost, int maxOperations) {
        int time = 0;
        for (int num : nums) {
            if (num % cost == 0) {
                time += num / cost - 1;
            } else {
                time += num / cost;
            }
        }
        return time <= maxOperations;
    }

    public void main(String[] args) {
        System.out.println(cuttingRope(3));
    }

    class Solution {
        boolean[][] visited;
        char[][] board;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        String word;

        public boolean exist(char[][] board, String word) {
            int h = board.length, w = board[0].length;
            visited = new boolean[h][w];
            this.board = board;
            this.word = word;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    boolean flag = check(i, j, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean check(int i, int j, int k) {
            if (board[i][j] != word.charAt(k)) {
                return false;
            } else if (k == word.length() - 1) {
                return true;
            }
            visited[i][j] = true;

            boolean result = false;
            for (int[] dir : directions) {
                int newi = i + dir[0], newj = j + dir[1];
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    if (!visited[newi][newj]) {
                        boolean flag = check(newi, newj, k + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
    }

    public class UnionSet {
        int count = 0;
        int[] parent;

        public UnionSet(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent[rootX] = rootY;
            count++;
        }
    }


}
