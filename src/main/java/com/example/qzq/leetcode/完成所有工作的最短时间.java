package com.example.qzq.leetcode;

import java.util.Arrays;

/**
 * @ClassName : 完成所有工作的最短时间
 * @Author : qiziqian
 * @Description:
 * @Date: 2021-01-13 17:29
 */
public class 完成所有工作的最短时间 {

    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {

        Arrays.sort(jobs);
        int[] group = new int[k];
        dfs(jobs, group, k, 0);
        return res;
    }

    public void dfs(int[] jobs, int[] group, int k, int currJob) {
        if (currJob == jobs.length) {
            int max = 0;
            for (int i : group) {
                max = Math.max(max, i);
            }
            res = Math.min(res, max);
        }

        for (int i = 0; i < k; i++) {
            if (group[i] > res) continue;
            group[i] += jobs[currJob];
            dfs(jobs, group, k, currJob + 1);
            group[i] -= jobs[currJob];
        }
    }

}