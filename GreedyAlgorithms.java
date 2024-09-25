import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithms {

	// very important
	// Vid 27.5 --> Why this approach is correct
	public static int maxActivities(int[] start, int[] end, ArrayList<Integer> idx) {												// O(n)
		idx.add(0);
		int maxAct = 1;
		int lastEnd = end[0];
		for(int i=1; i<end.length; i++) {
			if(start[i] >= lastEnd) {
				idx.add(i);
				maxAct++;
				lastEnd = end[i];
			}
		}
		return maxAct;
	}

	public static int maxActivitiesUnsortedEnd(int[] start, int[] end, ArrayList<Integer> idx) {									// O(n × log₂(n))
		int[][] activities = new int[start.length][3];
		for(int i=0; i<start.length; i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}
		Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));									// Lambda Function			O(n × log₂(n))
		idx.add(activities[0][0]);
		int maxAct = 1;
		int lastEnd = activities[0][2];
		for(int i=1; i<activities.length; i++) {
			if(activities[i][1] >= lastEnd) {
				idx.add(activities[i][0]);
				maxAct++;
				lastEnd = activities[i][2];
			}
		}
		return maxAct;
	}

	public static int fractionalKnapsack(int[] value, int[] weight, int capacity) {													// O(n × log₂(n))
		int n = value.length;
		double[][] ratio = new double[n][2];
		for(int i=0; i<n; i++) {
			ratio[i][0] = i;
			ratio[i][1] = value[i] / (double)weight[i];
		}
		Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
		int maxValue = 0;
		for(int i=n-1; i>=0; i--) {
			int idx = (int)ratio[i][0];
			if(capacity >= weight[idx]) {
				maxValue += value[idx];
				capacity -= weight[idx];
			}
			else {
				maxValue += (capacity * value[idx]) / weight[idx];
				capacity = 0;
				break;
			}
		}
		return maxValue;
	}

	public static int minAbsDiff(int[] A, int[] B) {																				// O(n × log₂(n))
		Arrays.sort(A);
		Arrays.sort(B);
		int minAbsDiff = 0;
		for(int i=0; i<A.length; i++) {
			minAbsDiff += Math.abs(A[i] - B[i]);
		}
		return minAbsDiff;
	}
	
	public static int maxChains(int[][] pairs) {												// Max activities wale question ka deviation hai ye
		Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
		int chainEnd = pairs[0][1];
		int maxChains = 1;
		for(int i=1; i<pairs.length; i++) {
			if(pairs[i][0] > chainEnd) {
				maxChains++;
				chainEnd = pairs[i][1];
			}
		}
		return maxChains;
	}

	public static int minCoins(int value, Integer[] coins) {
		Arrays.sort(coins, Comparator.reverseOrder());
		int minCoins = 0;
		for(int i=0; i<coins.length; i++) {
			if(coins[i] <= value) {
				minCoins += value / coins[i];
				value -= coins[i] * (value / coins[i]);
			}
		}
		return minCoins;
	}

	public static int maxProfit(int[][] job) {
		Arrays.sort(job, Comparator.comparingDouble(o -> o[0]));
		int maxProfit = 0;
		for(int i=0; i<job.length;) {
			int currMax = Integer.MIN_VALUE;
			int deadline = job[i][0];
			while(i < job.length && deadline == job[i][0]) {
				currMax = Math.max(currMax, job[i][1]);
				i++;
			}
			maxProfit += currMax;
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[][] job = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
		System.out.println(maxProfit(job));
	}

}
