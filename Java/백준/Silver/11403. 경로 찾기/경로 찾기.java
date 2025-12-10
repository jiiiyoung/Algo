import java.io.*;
import java.util.*;

class Main {
	static int N;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// 갈 수 있는 경로를 찾기.
		// 행렬을 읽어 인접행렬로 구분, 그리고 이중for문으로 한칸한칸 확인.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
	
		for(int i = 0; i < N; i++) {
			String[] nodes = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				Integer node = Integer.parseInt(nodes[j]);
				
				if (node == 1) {
					graph.get(i).add(j);
				}
			}
		}
		
		String[][] result = new String[N][N];
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < N; j++) {
				visited = new boolean[N];

				if (dfs(i, j)) {
					result[i][j] = "1";
				}else {
					result[i][j] = "0";					
				}
			}
		}		
		
		for(int i = 0; i< N; i++) {
			System.out.println(String.join(" ",  result[i]));
		}
	}

	static boolean dfs(int s, int e) {
		
		boolean result = false;
		

		for(int node: graph.get(s)) {
			if(node == e) {
				return true;
			}
			if (visited[node]) {
				continue;
			}
			visited[node] = true;
			result = dfs(node, e);
			
			if (result) {
				return result;
			}
		}
		return result;
	}
	
}