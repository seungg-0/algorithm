import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이가 있는 위치
        int N = Integer.parseInt(st.nextToken());
        // 동생이 있는 위치
        int K = Integer.parseInt(st.nextToken());

        // 탐색을 위한 배열 (최대 범위를 고려하여 넉넉하게 100001로 설정)
        // 각 인덱스(위치)에 시간 값을 저장한다.
        int[] findMySister = new int[100001];

        if (N == K) {
            System.out.println(0); // 수빈이와 동생이 같은 위치에 있을 경우
        } else {
            bfs(findMySister, N, K);
        }
    }

    private static void bfs(int[] findMySister, int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N); // 초기 위치 삽입
        findMySister[N] = 1; // 수빈이의 초기 위치를 1로 표시 (0초부터 시작하기 위해)

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 곱하기, 더하기, 빼기 세 가지 경우의 수를 모두 해준다.
            for (int i = 0; i < 3; i++) {
                int temp;

                if (i == 0) {
                    temp = now * 2; // 순간 이동
                } else if (i == 1) {
                    temp = now + 1; // 앞으로 1칸
                } else {
                    temp = now - 1; // 뒤로 1칸
                }

                // 범위 내에 있는지 확인하고, 이미 방문했는지 체크
                if (temp >= 0 && temp < 100001 && findMySister[temp] == 0) {
                    findMySister[temp] = findMySister[now] + 1; // 몇 초 걸렸는지 기록

                    if (temp == K) {
                        System.out.println(findMySister[temp] - 1); // 결과 출력 (초는 1부터 시작했으므로 -1)
                        return;
                    }

                    queue.add(temp); // 다음 위치를 큐에 삽입
                }
            }
        }
    }
}