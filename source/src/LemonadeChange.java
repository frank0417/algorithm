public class LemonadeChange {
    /*
     * 题 目：柠檬水找零
     * 链 接: https://leetcode-cn.com/problems/lemonade-change
     * 描 述：在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
     *       顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *       每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，
     *       也就是说净交易是每位顾客向你支付 5 美元。
     *       注意，一开始你手头没有任何零钱。
     *       如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     */
    public boolean lemonadeChange(int[] bills) {
        int len = 0;
        if (bills == null || (len = bills.length) == 0) return true;
        int m5 = 0, m10 = 0;
        for (int i = 0; i < len; ++i) {
            if (bills[i] == 5) {
                m5++;
            } else if (bills[i] == 10) {
                m10++;
                m5--;
            } else if (bills[i] == 20) {
                if (m10 > 0) {
                    m10--;
                    m5--;
                } else {
                    m5 -= 3;
                }
            }
            if (m5 < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange l = new LemonadeChange();
        l.lemonadeChange(new int[]{5, 5, 5, 5, 10, 5, 10, 10, 10, 20});
    }

}
