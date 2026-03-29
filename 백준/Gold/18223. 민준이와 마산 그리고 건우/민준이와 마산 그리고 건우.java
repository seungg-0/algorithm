// 출발 1, 마산 가장 큰 정점, 건우 P
// 최단거리내에 건우가 있으면 SAVE HIM 아니면 GOOD BYE
// 1-V 정점간 최단거리 : 다익스트라 (음수간선 없음, 출발지 존재)
// 1. 출발지 1로 해서 다익스트라 구하기 (그 구간에 P 있으면 SAVE HIM) : 땡 !!!
// 1-V 다익스트라 거리 = 1-P + P-V 인게 있으면 SAVE HIM
// 즉, 다익스트라 두 번 구해야 함 (1에서 시작, P에서 시작)



import java.util.*;
import java.io.*;

public class Main{
    static int V, E, P;
    static ArrayList<Node>[] nodes;
    static int[] dist1, distP;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        nodes = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            nodes[i] = new ArrayList<>();
        }
        
        for(int i=0; i<E; i++){ // 연결 정보 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }
        
        dist1 = new int[V+1];
        distP = new int[V+1];
        dist1 = dijkstra(1, dist1); // 출발지점 1
        distP = dijkstra(P, distP); // 출발지점 P
        String answer = "";
        for(int i=1; i<=V; i++){
            if(dist1[V]==dist1[P]+distP[V]){
                answer = "SAVE HIM";
                break;
            }
        }
        System.out.println(answer.length()!=0 ? answer : "GOOD BYE");
    }
    
    static int[] dijkstra(int n, int[] dist){
        boolean[] visited = new boolean[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));
        dist[n] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.index]) continue;
            visited[now.index] = true;
            for(Node next : nodes[now.index]){
                if(dist[next.index]>dist[now.index]+next.cost){
                    dist[next.index] = dist[now.index]+next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist;
    }
    
    static class Node implements Comparable<Node>{
        int index;
        int cost;
        
        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
    }
}