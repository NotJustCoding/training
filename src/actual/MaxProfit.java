package actual;

/**
 * @description:
 * @author: ZhaoYang
 * @create: 2021-03-29 15:40
 */
public class MaxProfit {
    
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意你不能在买入股票前卖出股票。
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (Integer.MAX_VALUE != minNum && prices[i] - minNum > maxProfit) {
                maxProfit = prices[i] - minNum;
            }
            
            if (prices[i] < minNum) {
                minNum = prices[i];
            }
        }
        return maxProfit;
    }
    
    /**
     * 成股票可以买卖多次, 但是你必须要在出售股票之前把持有的股票卖掉。
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        // 7,1,5,3,6,4
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i != 0 && prices[i] - prices[i-1] > 0) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
    
}
