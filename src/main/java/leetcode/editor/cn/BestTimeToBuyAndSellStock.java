//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
//
//
// 示例 2：
//
//
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
//
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 10⁵
// 0 <= prices[i] <= 10⁴
//
// Related Topics 数组 动态规划 👍 1982 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        Assertions.assertEquals(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        Assertions.assertEquals(0, solution.maxProfit(new int[]{7,6,4,3,1}));
        Assertions.assertEquals(0, solution.maxProfit(new int[]{1}));
        Assertions.assertEquals(1, solution.maxProfit(new int[]{1,2}));
        Assertions.assertEquals(0, solution.maxProfit(new int[]{2,1}));
        Assertions.assertEquals(0, solution.maxProfit(new int[]{2,2}));
        Assertions.assertEquals(99, solution.maxProfit(new int[]{7, 1, 100, 3, 6, 4}));
        Assertions.assertEquals(199, solution.maxProfit(new int[]{7, 1, 100, 3, 200, 4}));
        Assertions.assertEquals(197, solution.maxProfit(new int[]{7, 5, 100, 3, 200, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int buy = prices[0];
            int sell = prices[0];
            int result = sell - buy;
            for (int price : prices) {
                // 如果后面出现的价格低于第一个买的价格,就转入这个价格买入
                if (price < buy) {
                    buy = price;
                //    此时卖出价格必须往后移动,
                    sell = price;
                }
                // 如果后面出现的价格高于卖出的价格,就用这个价格卖出
                if (price > sell) {
                    sell = price;
                //    检查一下这个价格卖出的利润,是否大于之前存储的情况卖出的利润
                    result = Math.max(sell - buy, result);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
