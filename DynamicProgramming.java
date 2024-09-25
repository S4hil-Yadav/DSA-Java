import java.util.Arrays;

public class DynamicProgramming {

	static int fibMEM(int n, int[] dp) {
		if(n <= 1) {
			return n;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		dp[n] = fibMEM(n-1, dp) + fibMEM(n-2, dp);
		return dp[n];
	}
	static int fibTAB(int n) {
		if(n <= 1) {
			return n;
		}
		int[] dp = new int[n+1];
		dp[1] = 1;
		for(int i=2; i<n+1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

	static int stairsMEM(int n, int[] dp) {
		if(n <= 1) {
			return 1;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		dp[n] = stairsMEM(n-1, dp) + stairsMEM(n-2, dp);
		return dp[n];
	}
	static int stairsTAB(int n) {
		if(n <= 1) {
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0] = dp[1] = 1;
		for(int i=2; i<n+1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

	static int knapsack01MEM(int val[], int[] wt, int W, int n, int[][] dp) {
		if(W == 0 || n == val.length) {
			return 0;
		}
		if(dp[n][W] != -1) {
			return dp[n][W];
		}
		if(wt[n] <= W) {
			int ans1 = val[n] + knapsack01MEM(val, wt, W-wt[n], n+1, dp);
			int ans2 = knapsack01MEM(val, wt, W, n+1, dp);
			dp[n][W] = Math.max(ans1, ans2);
		}
		else {
			dp[n][W] = knapsack01MEM(val, wt, W, n+1, dp);
		}
		return dp[n][W];
	}
	static int knapsack01TAB(int[] val, int[] wt, int W) {
		int n = val.length;
		int[][] dp = new int[n+1][W+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<W+1; j++) {
				int v = val[i-1];
				int w = wt[i-1];
				if(w <= j) {
					int ans1 = v + dp[i-1][j-w];
					int ans2 = dp[i-1][j];
					dp[i][j] = Math.max(ans1, ans2);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][W];
	}
	static boolean targetSum(int[] nums, int sum) {
		int n = nums.length;
		boolean[][] dp = new boolean[n+1][sum+1];
		for(int i=0; i<n+1; i++) {
			dp[i][0] = true;
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				int v = nums[i-1];
				if(dp[i-1][j]) {
					dp[i][j] = true;
				}
				else if(v <= j && dp[i-1][j-v]) {
					dp[i][j] = true;
				}
			}
		}
		return dp[n][sum];
	}
	static int unboundedKnapsack(int[] val, int[] wt, int W) {
		int n = val.length;
		int[][] dp = new int[n+1][W+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<W+1; j++) {
				int v = val[i-1];
				int w = wt[i-1];
				if(w <= j) {
					int ans1 = v + dp[i][j-w];
					// int f = j/w;
					// int ans1 = v*f + dp[i-1][j-w*f];
					int ans2 = dp[i-1][j];
					dp[i][j] = Math.max(ans1, ans2);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][W];
	}

	public static int changeCoins(int[] coins, int sum) {
		int n = coins.length;
		int[][] dp = new int[n+1][sum+1];
		for(int i=0; i<n+1; i++) {
			dp[i][0] = 1;
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(coins[i-1] <= j) {
					dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[n][sum];
	}

	public static int rodCutting(int[] length, int[] price, int totRod) {
		int n = price.length;
		int[][] dp = new int[n+1][totRod+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<totRod+1; j++) {
				if(length[i-1] <= j) {
					dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][totRod];
	}

	public static int LCSrec(String str1, String str2, int n, int m) {
		if(n == 0 || m == 0) {
			return 0;
		}
		if(str1.charAt(n-1) == str2.charAt(m-1)) {
			int subSeq = LCSrec(str1, str2, n-1, m-1);
			return (subSeq + 1);
		}
		else {
			int subSeq1 = LCSrec(str1, str2, n-1, m);
			int subSeq2 = LCSrec(str1, str2, n, m-1);
			int subSeq = Math.max(subSeq1, subSeq2);
			return (subSeq);
		}
	}

	public static int LCSmem(String str1, String str2, int n, int m, int dp[][]) {
		if(n == 0 || m == 0) {
			return 0;
		}
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		if(str1.charAt(n-1) == str2.charAt(m-1)) {
			dp[n][m] = LCSmem(str1, str2, n-1, m-1, dp) + 1;
			return dp[n-1][m-1];
		}
		else {
			int subSeq1 = LCSmem(str1, str2, n-1, m, dp);
			int subSeq2 = LCSmem(str1, str2, n, m-1, dp);
			dp[n][m] = Math.max(subSeq1, subSeq2);
			return dp[n][m];
		}
	}

	public static int LCStab(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n+1][m+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					int ans1 = dp[i-1][j];
					int ans2 = dp[i][j-1];
					dp[i][j] = Math.max(ans1, ans2);
				}
			}
		}
		return dp[n][m];
	}

	public static int LCSubStr(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n+1][m+1];
		int ans = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					ans = Math.max(ans, dp[i][j]);
				}
				else {
					dp[i][j] = 0;
				}
			}
		}
		return ans;
	}

	public static int LIS(int[] arr) {
		int n = arr.length;
		int[] arr2 = new int[n];
		for(int i=0; i<n; i++) {
			arr2[i] = arr[i];
		}
		Arrays.sort(arr2);
		int[][] dp = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(arr[i-1] == arr2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					int ans1 = dp[i-1][j];
					int ans2 = dp[i][j-1];
					dp[i][j] = Math.max(ans1, ans2);
				}
			}
		}
		return dp[n][n];
	}

	public static int editDistance(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n+1][m+1];
		for(int i=1; i<n+1; i++) {
			dp[i][0] = i;
		}
		for(int j=1; j<n+1; j++) {
			dp[j][0] = j;
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					int add = dp[i][j-1];
					int del = dp[i-1][j];
					int rep = dp[i-1][j-1];
					dp[i][j] = Math.min(add, Math.min(del, rep)) + 1;
				}
			}
		}
		return dp[n][m];
	}

	public static int strConv(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n+1][m+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return (n + m - 2*dp[n][m]);
	}

	public static boolean wildcard(String str, String card) {
		int n = card.length();
		int m = str.length();
		boolean[][] dp = new boolean[n+1][m+1];
		dp[0][0] = true;
		for(int i=1; i<n+1; i++) {
			if(card.charAt(i-1) == '*') {
				dp[i][0] = dp[i-1][0];
			}
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				char ch = card.charAt(i-1);
				if(ch == str.charAt(j-1) || ch == '?') {
					dp[i][j] = dp[i-1][j-1];
				}
				else if(ch == '*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
				else {
					dp[i][j] = false;
				}
			}
		}
		return dp[n][m];
	}

	public static int catalanMEM(int n, int[] dp) {
		if(n == 0 || n == 1) {
			return 1;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans += catalanMEM(i, dp) * catalanMEM(n-i-1, dp);
		}
		return dp[n] = ans;
	}

	public static int catalanREC(int n) {										// --> Count BSTs & Mountain Ranges
		int[] dp = new int[n+1];
		dp[0] = dp[1] = 1;
		for(int i=2; i<n+1; i++) {
			for(int j=0; j<i; j++) {
				dp[i] += dp[j] * dp[i-j-1];
			}
		}
		return dp[n];
	}

	public static int mcmMEM(int[] arr, int i, int j, int[][] dp) {
		if(i == j) {
			return 0;
		}
		if(dp[i][j] != 0) {
			return dp[i][j];
		}
		int minCost = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int cost1 = mcmMEM(arr, i, k, dp);
			int cost2 = mcmMEM(arr, k+1, j, dp);
			int cost3 = arr[i-1] * arr[k] * arr[j];
			minCost = Math.min(minCost, cost1 + cost2 + cost3);
		}
		return dp[i][j] = minCost;
	}

	public static void mcmTAB(int[] arr) {
		
	}

	public static void main (String[] args) {
		int[] arr = {1, 2, 3, 4, 3};
		int n = arr.length;
		System.out.println(mcmMEM(arr, 1, n-1, new int[n][n]));
	}

}
