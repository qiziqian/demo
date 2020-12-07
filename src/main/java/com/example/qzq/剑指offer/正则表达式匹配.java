package com.example.qzq.剑指offer;

/**
 * @ClassName : 正则表达式匹配
 * @Author : qiziqian
 * @Description: 抄作业
 * @Date: 2020-10-19 15:24
 */
public class 正则表达式匹配 {

    private static boolean isMatched = false;


    public static boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    /**
     * Date  2020/10/21
     * Description
     * 1.字符串是不是空串||正则是不是空串
     * 都是空串  ture
     * 字符串是空正则不是空  需要判断
     * 正则是空字符串不为空   false
     * <p>
     * 1.分两种情况:是"*"或者不是"*":
     * 1.是"*":
     * 1.假设"*"前面的字符有0个
     * 2.假设"*"前面的字符大于0个
     * 2.不是"*":
     * 1.判断char类型相等不相等
     * 2.判断是不是"."
     **/
    public static boolean isMatch2(String s, String p) {
        int strLength = s.length();
        int partenLength = p.length();
        boolean[][] dp = new boolean[strLength + 1][partenLength + 1];
        dp[0][0] = true;
        for (int i = 0; i <= strLength; i++) {
            for (int j = 1; j <= partenLength; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (j >= 2) {
                        dp[i][j] |= dp[i][j - 2];
                    }
                    if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        dp[i][j] |= dp[i - 1][j];
                    }

                }
            }
        }
        return dp[strLength][partenLength];
    }

    public static void main(String[] args) {


        System.out.println(isMatch6("aa", "a*"));
    }

    public static boolean isMatch6(String s, String p) {
        int strLength = s.length();
        int partenLength = p.length();
        boolean[][] dp = new boolean[strLength + 1][partenLength + 1];
        dp[0][0] = true;
        for (int i = 0; i < strLength; i++) {
            for (int j = 0; j < partenLength; j++) {
                if (p.charAt(j) != '*') {
                    if (headMatched(s, p, i, j)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                } else {
                    if (j >= 1) {
                        dp[i + 1][j + 1] = dp[i + 1][j];
                    }
                    if (j >= 1 && headMatched(s, p, i, j - 1)) {
                        dp[i + 1][j + 1] |= dp[i][j];
                    }

                }
            }
        }
        return dp[strLength][partenLength];
    }

    //判断s第i个字符和p第j个字符是否匹配
    public static boolean headMatched(String s, String p, int i, int j) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }

    /**
     * Description
     * Date  2020/10/21
     * <p>
     * dp(i−1)(j−1),                 s(i) = p(j) or p(j) = .
     * dp(i)(j−2),                   p(j) = *, p(j-1) != s(i)
     * dp(i)(j)=      dp(i−1)(j) or dp(i)(j−2),     p(j) = *, p(j-1)=s(i) or p(j-1) = .
     * false                         else
     **/
    public boolean isMatch3(String s, String p) {
        int strLength = s.length();
        int partenLength = p.length();
        boolean[][] dp = new boolean[strLength + 1][partenLength + 1];
        dp[0][0] = true;
        for (int i = 0; i <= strLength; i++) {
            for (int j = 1; j <= partenLength; j++) {
                if (p.charAt(j) != '*') {
                    if (i > 0 && headMatched(s, p, i - 1, j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (j >= 2) {
                        dp[i][j] = dp[i][j - 2];
                    }
                    if (i >= 1 && j >= 2 && headMatched(s, p, i - 1, j - 2)) {
                        dp[i][j] |= dp[i - 1][j];
                    }

                }
            }
        }
        return dp[strLength][partenLength];
    }

    public boolean isMatch4(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        //填写第一行dp[0][2]~dp[0][p.length]
        for (int k = 2; k <= p.length(); k++) {
            //p字符串的第2个字符是否等于'*',此时j元素需要0个，所以s不变p减除两个字符
            dp[0][k] = p.charAt(k - 1) == '*' && dp[0][k - 2];
        }

        //填写dp数组剩余部分
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //p第j个字符是否为*
                if (p.charAt(j) == '*') {
                    //两种情况:1.s不变[i+1],p移除两个元素[j+1-2]。
                    // 2.比较s的i元素和p的j-1(因为此时j元素为*)元素,相等则移除首元素[i+1-1],p不变。
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || (dp[i][j + 1] && headMatched(s, p, i, j - 1));
                } else {
                    //s的i元素和p的j元素是否相等,相等则移除s的i元素[i+1-1]和p的j元素[j+1-1]
                    dp[i + 1][j + 1] = dp[i][j] && headMatched(s, p, i, j);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * Author qiziqian
     * Description    自己的思路的
     * Date  2020/10/22
     **/
    public boolean myIsMatch(String s, String p) {
        int strLength = s.length();
        int partenLength = p.length();
        boolean[][] dp = new boolean[strLength + 1][partenLength + 1];


        dp[0][0] = true;
        for (int k = 2; k <= p.length(); k++) {
            dp[0][k] = p.charAt(k - 1) == '*' && dp[0][k - 2];
        }

        for (int i = 0; i < strLength; i++) {
            for (int j = 0; j < partenLength; j++) {
                if (p.charAt(j) != '*') {
                    if (headMatched(s, p, i, j)) dp[i + 1][j + 1] = dp[i][j];
                } else {
                    if (j >= 1) dp[i + 1][j + 1] = dp[i + 1][j - 1] || (headMatched(s, p, i, j - 1) && dp[i][j + 1]);

                }
            }
        }
        return dp[strLength][partenLength];
    }
}