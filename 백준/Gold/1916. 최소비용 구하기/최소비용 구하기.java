import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int city;
        int cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용이 작은 순서로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<int[]>> busLine = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            busLine.add(new ArrayList<>());
        }

        // 버스 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            busLine.get(s).add(new int[]{e, c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라용 dist 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int city = current.city;
            int cost = current.cost;

            // 이미 더 작은 비용으로 방문했으면 스킵
            if (cost > dist[city]) continue;

            for (int[] next : busLine.get(city)) {
                int nextCity = next[0];
                int nextCost = next[1];

                if (dist[nextCity] > dist[city] + nextCost) {
                    dist[nextCity] = dist[city] + nextCost;
                    pq.offer(new Node(nextCity, dist[nextCity]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
