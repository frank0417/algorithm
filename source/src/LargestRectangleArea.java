import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea {
    /*
     * 题 目：柱状图中最大的矩形
     * 链 接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
     * 描 述：给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。求在该柱状图中，能够勾勒出来的矩形的最大面积。
     */
    public int largestRectangleArea(int[] heights) {
        int length = 0, maxArea = 0;
        if (heights == null) return 0;
        if ((length = heights.length) == 1) return heights[0];
        for (int i = 0; i < length; ++i) {
            int left = i, right = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < length && heights[right] >= heights[i]) {
                right++;
            }
            maxArea = Math.max(maxArea, heights[i] * (right - left - 1));
        }
        return maxArea;
    }

    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        int length = 0;
        if (heights == null || (length = heights.length) == 0) return 0;
        for (int i = 0; i < length; ++i) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < length; ++j) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        int length = 0;
        if (heights == null || (length = heights.length) == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < length; ++i) {
            if (i > 0 && heights[i] < heights[stack.peek()]) {
                while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                    maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (length -stack.peek()-1));
        }
        return maxArea;
    }


    public int largestRectangArea3(int[] heights){
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        l.largestRectangleArea2(new int[]{2,4});
    }
}
