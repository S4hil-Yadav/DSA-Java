public class Stocks {
    public static int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            int currentProfit = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
