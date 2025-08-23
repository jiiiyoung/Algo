import java.util.*;
import java.io.*;

public class Main{

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static Map <Integer, Integer> answer = new HashMap<>();

    public static void main(String[] args) throws IOException{
        // N 후에 그래프
        // 그래프 넣기.(양방향으로 넣고, 1부터 조회. 해당이 있으면 그의 부모를 알아야함. 부모는 재귀에서 들고다니기.)
        // dfs로 찾아서 해당 부모 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            String[] temp = br.readLine().split(" ");

            graph.get(Integer.parseInt(temp[0]) - 1).add(Integer.parseInt(temp[1]) - 1);
            graph.get(Integer.parseInt(temp[1]) - 1).add(Integer.parseInt(temp[0]) - 1);
        }


        // 0부터 타면서 map에 각각 key value 저장.
        dfs(0);

        for(int i=2; i <= N; i++){
            System.out.println(answer.getOrDefault(i, 1));
        }
    }

    public static void dfs(int node){
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for(int child : graph.get(node)){
            if (!visited[child]){
                answer.put(child + 1, node + 1); // 부모 노드 저장
                dfs(child);
            }
        }

    }
}