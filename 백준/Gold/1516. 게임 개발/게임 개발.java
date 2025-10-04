import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        //그래프 이차원 리스트
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        //특정 건물을 지을 때, 먼저 지어져야 할 건물 개수 (=진입차수 저장 배열)
        int[] indegree = new int[n + 1];
        //특정 건물을 지을 때, 걸리는 시간
        int[] time = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                } else {
                    list.get(num).add(i); // num 건물 → i 건물
                    indegree[i]++;
                }
            }
        }
        

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }

        //각 건물이 완성되기까지 걸리는 최소 시간
        // result[i] : i건물을 짓기 전까지 필요한 최소 시간 (=선행 건물들이 끝나는 시간 중 최댓값)
        // time[i] : i 건물 자체를 짓는 데 걸리는 시간
        // 따라서 최종 완공 시간 = result[i] + time[i]
        
        int[] result = new int[n + 1];
        while (!que.isEmpty()) {
            int now = que.poll(); // 현재 건물을 하나 꺼낸다. (큐에는 "지을 준비가 끝난 건물"이 들어있음
            // 즉, now 건물은 이미 모든 선행 조건이 만족된 상태 

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i); // now 다음에 지을 수 있는 건물
                indegree[next]--; // next는 now를 먼저 지어야 지을 수 있는 건물. now가 끝났으니 next의 필요한 선행 조건 개수 하나 감소
                
                // next 건물을 짓기 전까지 걸린 시간 계산
                // result[now] + time[now] = now건물이 끝난 시점 
                // next건물은 여러 개의 선행 건물이 있을 수 있고, 그 중 가장 늦게 끝나는 건물을 기다려야 함
                result[next] = Math.max(result[next], result[now] + time[now]); // 선행 건물 완공시간 중 가장 늦은 값 구하는 중
                
                if (indegree[next] == 0) { // next의 모든 선행 건물이 끝났다면 큐에 넣어서 다음 차례에 지을 수 있도록 함.
                    que.offer(next);
                }
            }
        }

        //위에서 next 건물 짓기 전까지 걸린 시간을 계산하였으니, next 건물이 지어진 후 걸린 시간까지 계산하여 출력
        for (int i = 1; i <= n; i++) {
            sb.append(result[i] + time[i]).append("\n");
        }

        System.out.println(sb);
    }
}