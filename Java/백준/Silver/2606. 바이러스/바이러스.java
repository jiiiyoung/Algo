import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int comCount = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> com = new ArrayList<>();

        for (int i = 0; i < comCount; i++) {
            com.add(new ArrayList<>());
        }

        // 값 입력
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]) - 1;
            int end = Integer.parseInt(temp[1]) - 1;

            com.get(start).add(end);
            com.get(end).add(start);
        }

        int[] visited = new int[comCount];

        dfs(0, com, visited);

        System.out.println(count);

    }

    public static void dfs(int in, List<List<Integer>> virus, int[] visited ){
        visited[in] = 1; // 방문 표시
        for (int i = 0; i < virus.get(in).size(); i++) {
            // 다음 방문지가 방문하지 않은 곳일 경우에만 방문
            if (visited[virus.get(in).get(i)] == 0) {
                dfs(virus.get(in).get(i), virus, visited);
                count++;
            }
        }


    }
}