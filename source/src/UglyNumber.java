import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumber {
    /*
     * 题 目：丑数
     * 链 接：https://leetcode-cn.com/problems/chou-shu-lcof/
     * 描 述：我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> s = new HashSet<>();
        long[] primes = new long[]{2, 3, 5};
        for (long prime : primes) {
            pq.offer(prime);
            s.add(prime);
        }
        long num = 1;
        for (int i = 1; i < n; i++) {
            num = pq.poll();
            for (int j = 0; j < 3; j++) {
                if (!s.contains(num * primes[j])) {
                    pq.offer(num * primes[j]);
                    s.add(num * primes[j]);
                }
            }
        }
        return (int) num;
    }

    //动态规划
    public int nthUglyNumber1(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }
        return dp[n - 1];
    }
}
