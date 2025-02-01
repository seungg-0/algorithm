import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Integer>[] linkedInfo;
    static int[] result;
    static Queue<Integer> queue;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        linkedInfo = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            linkedInfo[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) { // 연결 정보 저장
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            linkedInfo[s].add(e);
            linkedInfo[e].add(s);
        }

        result = new int[N + 1]; // 케빈 베이컨 수를 저장할 배열
        for (int i = 1; i <= N; i++) { // 사람별 케빈 베이컨 수 구하기
            queue = new LinkedList<>();
            result[i] = BFS(i, queue);
        }

        // 케빈 베이컨 수가 가장 작은 사람 찾아서 출력하기
        int minimum = Integer.MAX_VALUE; // [암기]
        for (int i = 1; i <= N; i++) {
            minimum = Math.min(minimum, result[i]);
        }
        for (int i = 1; i <= N; i++) {
            if (minimum == result[i]) {
                System.out.println(i); // 최소값을 가지는 사람 출력
                break;
            }
        }
    }

    static int BFS(int start, Queue<Integer> queue) {
        int[] nums = new int[N + 1]; // 각 사람과의 거리를 저장할 배열
        visited = new boolean[N + 1]; // 방문 여부를 체크할 배열
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int nowPerson = queue.poll();

            // 연결된 사람들을 탐색
            for (int nextPerson : linkedInfo[nowPerson]) {
                if (!visited[nextPerson]) {
                    nums[nextPerson] = nums[nowPerson] + 1; // 거리 증가
                    visited[nextPerson] = true;
                    queue.add(nextPerson);
                }
            }
        }

        // 모든 사람과의 거리를 합산
        int total = 0;
        for (int n = 1; n <= N; n++) {
            total += nums[n];
        }
        return total; // 해당 사람의 케빈 베이컨 수
    }
}
