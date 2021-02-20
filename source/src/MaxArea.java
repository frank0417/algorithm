public class MaxArea {
    /*
     * 题 目：盛最多水的容器
     * 链 接：https://leetcode-cn.com/problems/container-with-most-water/
     * 描 述：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点  (i,  ai) 。在坐标内画 n 条垂直线，垂直线 i  的两个端点分别为  (i,  ai) 和 (i, 0) 。找出其中的两条线，使得它们与  x  轴共同构成的容器可以容纳最多的水。
     */
    public int maxArea(int[] height) {
        int length = 0;
        if (height == null || (length = height.length) == 0) return 0;
        int maxArea = 0;
        int j = length - 1;
        for (int i = 0; i < j; ) {
            int minHeight = height[i] > height[j] ? height[j--] : height[i++];
            int curArea = minHeight * (j - i + 1);
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }

    public int maxArea1(int[] height) {
        int len = 0;
        if (height == null || (len = height.length) == 0) return 0;
        int maxArea = 0;
        int i=0;
        int j = len - 1;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight * (j - i);
            maxArea = Math.max(area, maxArea);
            if(height[i]<height[j]){
                while(height[i]>height[++i]);
            }else if(height[i]>height[j]){
                while (height[j]>height[--j]);
            }else{
                i++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int area = maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(area);
    }
}
