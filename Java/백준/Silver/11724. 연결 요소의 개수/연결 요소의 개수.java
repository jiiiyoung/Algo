import java.io.*;
import java.util.*;

class Main{

    static boolean[] visited;
    static List<List<Integer>> graph;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");

        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        visited = new boolean[N];
        graph = new ArrayList<>();


        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }


        // 그래프 입력
        for(int i = 0; i < M; i++) {
            String[] nodes = br.readLine().split(" ");

            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);

            graph.get(u-1).add(v-1);
            graph.get(v-1).add(u-1);

        }


        // 탐색하기
        int result = 0;
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i]= true;
                q.add(i);
                bfs();
                result++;
            }
        }

        System.out.println(result);
    }

    static void bfs() {

        while(!q.isEmpty()) {

            int current = q.poll();

            List<Integer> child = graph.get(current);
            for(int i = 0; i < child.size(); i++) {
                int next = child.get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }


        }


    }

}