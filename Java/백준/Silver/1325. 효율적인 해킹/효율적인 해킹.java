import java.util.*;
import java.io.*;

public class Main {

	static List<List<Integer>> graph = new ArrayList<>();
	static int[] visited;
	static int count;
	static Queue<Integer> q = new LinkedList<>();


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputNM = br.readLine().split(" ");

		int N = Integer.parseInt(inputNM[0]);
		int M = Integer.parseInt(inputNM[1]);
		
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 그래프 입력
		for(int i = 0; i < M; i++) {
			String[] temp = br.readLine().split(" ");
			
			int A = Integer.parseInt(temp[0]);
			int B = Integer.parseInt(temp[1]);
			
			graph.get(B - 1).add(A - 1);
		}
		
		// 그래프 탐색
		int max = 0;
		int[] answer = new int[N];
		visited = new int[N];
		for(int i = 0; i < N; i++) {
			count = 0;
			bfs(i, i+1);
			
			if (count > max) {
				max = count; // 최댓값 갱신
			}
			answer[i] = count;			
		}
		
		
		StringBuilder sb = new StringBuilder();
		// 정답 출력
		for (int i = 0; i < N; i++) {
			if (answer[i] == max) {
				sb.append( (i + 1) ).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	static void bfs(int start, int ver){

		q.add(start);
		visited[start] = ver;

		while (!q.isEmpty()) {
			
			int node = q.poll();
			count++; // 방문 수 세기

			for(int child: graph.get(node)) {
				if ( visited[child] != ver){
					visited[child] = ver; // 방문표시
					q.add(child);
				}
			}
		}
		
	}
}
