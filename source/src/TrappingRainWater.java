import java.util.Stack;

public class TrappingRainWater {
    /*
     * 题 目：接雨水
     * 链 接：https://leetcode-cn.com/problems/trapping-rain-water/
     * 描 述：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }


    public int trapII(int[] height) {
        if (height.length < 3) return 0;
        int capacity = 0;
        int ll = 0;
        int rr = height.length - 1;
        while (ll < rr && height[ll] <= height[ll + 1]) {
            ll++;
        }
        while (ll < rr && height[rr] <= height[rr - 1]) {
            rr--;
        }
        while (ll < rr) {
            int left = height[ll];
            int right = height[rr];
            if (left <= right) {
                while (ll < rr && left >= height[++ll]) {
                    capacity += left - height[ll];
                }
            } else {
                while (ll < rr && right > height[--rr]) {
                    capacity += right - height[rr];
                }
            }
        }
        return capacity;
    }


    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int result = trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(result);
    }
}
