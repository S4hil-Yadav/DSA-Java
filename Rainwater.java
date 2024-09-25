public class Rainwater {
	public static int maxProfit(int[] stockPrice) {
		int n = stockPrice.length;
		int[] rightMax = new int[n];
		rightMax[n-1] = stockPrice[n-1];
		for(int i=n-2; i>=0; i--) {
			rightMax[i] = Math.max(stockPrice[i], rightMax[i+1]);
		}
		int profit = 0;
		for(int i=0; i<n; i++) {
			profit += rightMax[i] - stockPrice[i];
		}
		return profit;
	}
	public static void main(String[] args) {
		int[] price = {7,1,5,3,6,4};
		System.out.println(maxProfit(price));
	}
}