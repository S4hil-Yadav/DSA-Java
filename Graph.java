import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Collections;

public class Graph {

	static int v;

	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int wt;
		Edge(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
		@Override
		public int compareTo(Edge e2) {
			return (this.wt - e2.wt);
		}
	}

	static ArrayList<Edge>[] createGraph1() {
		ArrayList<Edge>[] graph = new ArrayList[4];
		for(int i=0; i<4; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 5));

		graph[1].add(new Edge(1, 0, 5));
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 3));

		graph[2].add(new Edge(2, 1, 1));
		graph[2].add(new Edge(2, 3, 1));

		graph[3].add(new Edge(3, 2, 1));
		graph[3].add(new Edge(3, 1, 3));

		v = 4;
		return graph;
	}
	static ArrayList<Edge>[] createGraph2() {
		ArrayList<Edge>[] graph = new ArrayList[7];
		for(int i=0; i<7; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));

		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 3, 1));
		
		graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 4, 1));

		graph[3].add(new Edge(3, 1, 1));
		graph[3].add(new Edge(3, 4, 1));
		graph[3].add(new Edge(3, 5, 1));
		
		graph[4].add(new Edge(4, 2, 1));
		graph[4].add(new Edge(4, 3, 1));
		graph[4].add(new Edge(4, 5, 1));
		
		graph[5].add(new Edge(5, 3, 1));
		graph[5].add(new Edge(5, 4, 1));
		graph[5].add(new Edge(5, 6, 1));
		
		graph[6].add(new Edge(6, 5, 1));
		
		v = 7;
		return graph;
	}
	static ArrayList<Edge>[] createGraph3() {
		ArrayList<Edge>[] graph = new ArrayList[5];
		for(int i=0; i<5; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 1));
		// graph[0].add(new Edge(0, 2, 1));
		graph[0].add(new Edge(0, 3, 1));

		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 2, 1));
		
		// graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 1, 1));

		graph[3].add(new Edge(3, 0, 1));
		graph[3].add(new Edge(3, 4, 1));
		
		graph[4].add(new Edge(4, 3, 1));
		
		v = 5;
		return graph;
	}
	static ArrayList<Edge>[] createGraph4() {
		ArrayList<Edge>[] graph = new ArrayList[5];
		for(int i=0; i<5; i++) {
			graph[i] = new ArrayList<>();
		}

		// graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));

		// graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 3, 1));
		
		graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 4, 1));

		graph[3].add(new Edge(3, 1, 1));
		graph[3].add(new Edge(3, 4, 1));
		
		graph[4].add(new Edge(4, 2, 1));
		graph[4].add(new Edge(4, 3, 1));
		
		v = 5;
		return graph;
	}
	static ArrayList<Edge>[] createGraph5() {
		ArrayList<Edge>[] graph = new ArrayList[4];
		for(int i=0; i<4; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 2, 1));
		graph[0].add(new Edge(0, 3, 1));

		graph[1].add(new Edge(1, 0, 1));
		
		graph[2].add(new Edge(2, 3, 1));

		// graph[3].add(new Edge(3, 0, 1));
		
		v = 4;
		return graph;
	}
	static ArrayList<Edge>[] createGraph6() {
		ArrayList<Edge>[] graph = new ArrayList[6];
		for(int i=0; i<6; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[2].add(new Edge(2, 3, 1));

		graph[3].add(new Edge(3, 1, 1));
		
		graph[4].add(new Edge(4, 0, 1));
		graph[4].add(new Edge(4, 1, 1));
		
		graph[5].add(new Edge(5, 0, 1));
		graph[5].add(new Edge(5, 2, 1));

		v = 6;
		return graph;
	}
	static ArrayList<Edge>[] createGraph7() {
		ArrayList<Edge>[] graph = new ArrayList[6];
		for(int i=0; i<6; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 3, 1));

		graph[2].add(new Edge(2, 3, 1));

		graph[3].add(new Edge(3, 1, 1));

		graph[4].add(new Edge(4, 0, 1));
		graph[4].add(new Edge(4, 1, 1));

		graph[5].add(new Edge(5, 0, 1));
		graph[5].add(new Edge(5, 2, 1));

		v = 6;
		return graph;
	}
	static ArrayList<Edge>[] createGraph8() {
		ArrayList<Edge>[] graph = new ArrayList[6];
		for(int i=0; i<6; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		graph[1].add(new Edge(1, 3, 7));
		graph[1].add(new Edge(1, 2, 1));

		graph[2].add(new Edge(2, 4, 3));

		graph[3].add(new Edge(3, 5, 1));

		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));

		v = 6;
		return graph;
	}
	static ArrayList<Edge>[] createGraph9() {
		ArrayList<Edge>[] graph = new ArrayList[4];
		for(int i=0; i<4; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 2, 15));
		graph[0].add(new Edge(0, 3, 30));

		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 3, 40));

		graph[2].add(new Edge(2, 0, 15));
		graph[2].add(new Edge(2, 3, 50));

		graph[3].add(new Edge(3, 1, 40));
		graph[3].add(new Edge(3, 2, 50));

		v = 4;
		return graph;
	}
	static ArrayList<Edge>[] createGraphFlights(int[][] flights) {
		ArrayList<Edge>[] graph = new ArrayList[4];
		for(int i=0; i<4; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<flights.length; i++) {
			int src = flights[i][0];
			int dest = flights[i][1];
			int cost = flights[i][2];
			graph[src].add(new Edge(src, dest, cost));
		}
		v = 4;
		return graph;
	}
	static ArrayList<Edge> createGraph10() {
		ArrayList<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 10));
		edges.add(new Edge(0, 2, 15));
		edges.add(new Edge(0, 3, 30));
		edges.add(new Edge(1, 3, 40));
		edges.add(new Edge(2, 3, 50));
		v = 4;
		return edges;
	}

	static void bfs(ArrayList<Edge>[] graph) {																								// O(V+E)
		boolean[] visited = new boolean[v];																									// AM --> O(V²)
		for(int i=0; i<v; i++) {
			if(!visited[i]) {
				bfsUtil(graph, i, visited);
			}
		}
	}
	static void bfsUtil(ArrayList<Edge>[] graph, int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start); 
		while(!q.isEmpty()) {
			int curr = q.remove();
			if(!visited[curr]) {
				System.out.print(curr + " ");
				for(int i=0; i<graph[curr].size(); i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
				visited[curr] = true;
			}
		}
	}
	
	static void dfs(ArrayList<Edge>[] graph) {																								// O(V+E)
		boolean[] visited = new boolean[v];
		for(int i=0; i<v; i++) {
			if(!visited[i]) {
				dfsUtil(graph, i, visited);
			}
		}
	}
	static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
		System.out.print(curr + " ");
		visited[curr] = true;
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!visited[e.dest]) {
				dfsUtil(graph, e.dest, visited);
			}
		}
	}

	static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {													// O(V+E)
		if(src == dest) {
			return true;
		}
		visited[src] = true;
		for(int i=0; i<graph[src].size(); i++) {
			Edge e = graph[src].get(i);
			if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)) {
				return true;
			}
		}
		return false;
	}

	static boolean cycleExistsUndir(ArrayList<Edge>[] graph) {																					// O(V+E)
		boolean visited[] = new boolean[v];
		for(int i=0; i<v; i++) {
			if(!visited[i] && cycleExistsUndirUtil(graph, visited, i, -1)) {
				return true;
			}
		}
		return false;
	}
	static boolean cycleExistsUndirUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int par) {
		visited[curr] = true;
		for(Edge e : graph[curr]) {
			if(!visited[e.dest]) {
				if(cycleExistsUndirUtil(graph, visited, e.dest, curr)) {
					return true;
				}
			}
			else if(visited[e.dest] && e.dest != par) {
				return true;
			}
		}
		return false;
	}

	static boolean isBipartite(ArrayList<Edge> graph[]) {																					// O(V+E)
		char[] color = new char[v];																											// HW
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<v; i++) {
			if(color[i] == 0) {
				q.add(i);
				color[i] = 'y';
				while(!q.isEmpty()) {
					int curr = q.remove();
					for(Edge e : graph[curr]) {
						if(color[e.dest] == 0) {
							char nextColor = (color[curr] == 'y') ? 'b' : 'y';
							color[e.dest] = nextColor;
							q.add(e.dest);
						}
						else if(color[curr] == color[e.dest]) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	static boolean cycleExistsDir(ArrayList<Edge>[] graph) {																					// O(V+E)
		boolean visited[] = new boolean[v];
		for(int i=0; i<v; i++) {
			if(!visited[i] && cycleExistsDirUtil(graph, i, visited, new boolean[v])) {
				return true;
			}
		}
		return false;
	}
	static boolean cycleExistsDirUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] visStk) {
		visited[curr] = visStk[curr] = true;
		for(Edge e : graph[curr]) {
			if(!visited[e.dest] && cycleExistsDirUtil(graph, e.dest, visited, visStk)) {
				return true;
			}
			else if(visStk[e.dest]) {
				return true;
			}
		}
		visStk[curr] = false;
		return false;
	}

	// Topological Sorting can be performed only on DAGs (Directed Acyclic Graphs)
	static int[] topologicalSortDFS(ArrayList<Edge>[] graph) {																						// O(V+E)
		boolean[] visited = new boolean[v];
		Stack<Integer> stk = new Stack<>();
		for(int i=0; i<v; i++) {
			if(!visited[i]) {
				topologicalSortUtilDFS(graph, visited, i, stk);
			}
		}
		int[] res = new int[v];
		for(int i=0; i<v; i++) {
			// System.out.println(stk.pop());
			res[i] = stk.pop();
		}
		return res;
	}
	static void topologicalSortUtilDFS(ArrayList<Edge>[] graph, boolean[] visited, int curr, Stack<Integer> stk) {
		visited[curr] = true;
		for(Edge e : graph[curr]) {
			if(!visited[e.dest]) {
				topologicalSortUtilDFS(graph, visited, e.dest, stk);
			}
		}
		stk.push(curr);
	}

	static void topologicalSortBFS(ArrayList<Edge>[] graph) {
		Queue<Integer> q = new LinkedList<>();
		int[] indeg = calcIndeg(graph);
		for(int i=0; i<v; i++) {
			if(indeg[i] == 0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int curr = q.remove();
			System.out.print(curr + " ");
			for(Edge e : graph[curr]) {
				indeg[e.dest]--;
				if(indeg[e.dest] == 0) {
					q.add(e.dest);
				}
			}
		}
		System.out.println();
	}
	static int[] calcIndeg(ArrayList<Edge>[] graph) {
		int[] indeg = new int[v];
		for(int i=0; i<v; i++) {
			for(Edge e : graph[i]) {
				indeg[e.dest]++;
			}
		}
		return indeg;
	}

	static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {																// O(V^V)
		if(src == dest) {
			System.out.println(path + src);
			return;
		}
		for(Edge e : graph[src]) {
			printAllPath(graph, e.dest, dest, path + src);
		}
	}

	static class Pair1 implements Comparable<Pair1> {
		int n;
		int path;
		Pair1(int n, int path) {
			this.n = n;
			this.path = path;
		}
		@Override
		public int compareTo(Pair1 p2) {
			return (this.path - p2.path);
		}
	}																																				//		PQ Sorting	
	//																																							^
	// Based on greedy approach with lesser TC but doesn't work on -ve edges																					| 
	static int[] dijkstra(ArrayList<Edge>[] graph, int src) {																						// O(V + E×log₂V)
		boolean visited[] = new boolean[v];																											// Without PQ --> O(V²)
		int[] dist = new int[v];
		for(int i=0; i<v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		PriorityQueue<Pair1> pq = new PriorityQueue<>();
		pq.add(new Pair1(src, 0));
		while(!pq.isEmpty()) {
			Pair1 curr = pq.remove();
			if(!visited[curr.n]) {
				visited[curr.n] = true;
				for(Edge e : graph[curr.n]) {
					int u = e.src;
					int v = e.dest;
					int wt = e.wt;
					if(dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt;
						pq.add(new Pair1(v, dist[v]));
					}
				}
			}
		}
		return dist;
	}

	// Based on DP, works on -ve edges but has higher TC
	// Also doesn't work if a cycle has -ve weight (because min distance in such cases doesn't make any sense as travelling in that cycle will just keep reducing distance)
	static void bellmanFord(ArrayList<Edge>[] graph) {
		// To be continued....
	}

	// MST :- A minimum spanning tree or minimum weight spanning tree is the subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight
	static int prim(ArrayList<Edge>[] graph, int start) {																							// O(E×log₂E)
		boolean visited[] = new boolean[v];
		PriorityQueue<Pair2> pq = new PriorityQueue<>();
		pq.add(new Pair2(start, 0));
		int minCost = 0;
		while(!pq.isEmpty()) {
			Pair2 curr = pq.remove();
			if(!visited[curr.vertex]) {
				visited[curr.vertex] = true;
				minCost += curr.cost;
				for(Edge e : graph[curr.vertex]) {
					pq.add(new Pair2(e.dest, e.wt));
				}
			}
		}
		return minCost;
	}
	static class Pair2 implements Comparable<Pair2> {
		int vertex;
		int cost;
		Pair2(int v, int c) {
			this.vertex = v;
			this.cost = c;
		}
		@Override
		public int compareTo(Pair2 p2) {
			return (this.cost - p2.cost);
		}
	}

	static int cheapestFlightWithinKStops(ArrayList<Edge>[] graph, int src, int dest, int k) {
		int[] dist = new int[v];
		for(int i=0; i<v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(src, 0, 0));
		while(!q.isEmpty()) {
			Info curr = q.remove();
			if(curr.stops > k) {
				break;
			}
			for(Edge e : graph[curr.n]) {
				int u = curr.cost;
				int v = e.dest;
				int wt = e.wt;
				if(u + wt < dist[v] && curr.stops <= k) {
					dist[v] = u + wt;
					q.add(new Info(v, dist[v], curr.stops + 1));
				}
			}
		}
		if(dist[dest] == Integer.MAX_VALUE) {
			return -1;
		}
		return dist[dest];
	}
	static class Info {
		int n;
		int cost;
		int stops;
		Info(int n, int cost, int stops) {
			this.n = n;
			this.cost = cost;
			this.stops = stops;
		}
	}

	static int connectCities(int[][] cities) {
		boolean visited[] = new boolean[cities.length];
		PriorityQueue<Pair2> pq = new PriorityQueue<>();
		pq.add(new Pair2(0, 0));
		int minCost = 0;
		while(!pq.isEmpty()) {
			Pair2 curr = pq.remove();
			if(!visited[curr.vertex]) {
				visited[curr.vertex] = true;
				minCost += curr.cost;
				for(int i=0; i<cities[curr.vertex].length; i++) {
					if(cities[curr.vertex][i] != 0) {
						pq.add(new Pair2(i, cities[curr.vertex][i]));
					}
				}
			}
		}
		return minCost;
	}

	static class DisjointSet {
		private int[] par;
		private int[] rank;
		DisjointSet(int n) {
			par = new int[n];
			rank = new int[n];
			for(int i=0; i<n; i++) {
				par[i] = i;
			}
		}
		int find(int x) {
			if(x == par[x]) {
				return x;
			}
			par[x] = find(par[x]);
			return par[x];
		}
		void union(int x, int y) {
			int parX = find(x);
			int parY = find(y);
			if(rank[parX] == rank[parY]) {
				par[parY] = parX;
				rank[parX]++;
			}
			else if(rank[parX] > rank[parY]) {
				par[parY] = parX;
			}
			else {
				par[parX] = parY;
			}
		}
	}

	static int kruskal(ArrayList<Edge> edges) {																										// O(V+E×log₂E)
		Collections.sort(edges);
		DisjointSet ds = new DisjointSet(v);
		int mstCost = 0;
		for(int i=0; i<v-1; i++) {
			Edge e = edges.get(i);
			int parSrc = ds.find(e.src);
			int parDest = ds.find(e.dest);
			if(parSrc != parDest) {
				ds.union(e.src, e.dest);
				mstCost += e.wt;
			}
		}
		return mstCost;
	}

	static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {																			// O(row×col)
		int orgColor = image[sr][sc];
		if(orgColor == newColor) {
			return image;
		}
		floodFillUtil(image, sr, sc, orgColor, newColor);
		return image;
	}
	static void floodFillUtil(int[][] image, int row, int col, int color, int newColor) {
		if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != color) {
			return;
		}
		image[row][col] = newColor;
		floodFillUtil(image, row, col-1, color, newColor);
		floodFillUtil(image, row, col+1, color, newColor);
		floodFillUtil(image, row-1, col, color, newColor);
		floodFillUtil(image, row+1, col, color, newColor);
	}

	public static void main(String[] args) {
		ArrayList<Edge> edges = createGraph10();
		System.out.println(kruskal(edges));
	}

}
