import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static boolean[] visited;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]); // 정점 개수
        int M = Integer.parseInt(temp[1]); // 간선 개수
        int V = Integer.parseInt(temp[2]); // 시작점

        // dfs는 그 다음 것을 확인
        // bfs는 그 안에 들어간 것을 모두 q에 넣고 q가 빌때까지 하기.
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            String[] edges = br.readLine().split(" ");

            graph.get(Integer.parseInt(edges[0]) - 1).add(Integer.parseInt(edges[1]) - 1);
            graph.get(Integer.parseInt(edges[1]) - 1).add(Integer.parseInt(edges[0]) - 1);
        }

        // visited 함수 초기화
        visited = new boolean[N];
        dfs(V - 1);

        System.out.println();

        // visited 함수 초기화
        visited = new boolean[N];
        bfs(V - 1);

    }

    public static void dfs(int node){
        if ( visited[node] ){
            return;
        }

        visited[node] = true;
        System.out.print( (node + 1 ) + " ");

        List<Integer> children = graph.get(node);
        children.sort((o1, o2) -> o1 - o2);

        for (int child : children){
            if ( !visited[child] ){
                dfs(child);
            }

        }
    }

    public static void bfs(int node){
        // Q에 담아두고, q가 없으면 끝
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        while(!queue.isEmpty()){
            int current = queue.poll();

            if (visited[current]){
                continue;
            }
            visited[current] = true;
            System.out.print( (current + 1) + " ");

            List<Integer> children = graph.get(current);
            children.sort((o1, o2) -> o1 - o2);

            for(int child: children){
                if ( !visited[child] ){
                    queue.add(child);
                }

            }
        }
    }
}