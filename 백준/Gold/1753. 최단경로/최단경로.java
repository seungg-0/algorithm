// 최단거리 구하기, 가중치 음수x -> 다익스트라 알고리즘 사용 

import java.io.*;
import java.util.*;

public class Main{
    static int V, E, start;
    static List<Node>[] graph;
    static int[] dist;
    
    public static void main(String[] arge)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[V+1]; // [제발 까먹지 마] 
        for(int i=0; i<=V; i++){
            graph[i] = new ArrayList<>();
        }
        
        int s, e, c;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, c)); // 연결 정보 저장 (도착지, 비용)
        }
        
        dijkstra(start);
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(dist[i]==Integer.MAX_VALUE){
                sb.append("INF").append('\n');
            }else {
                sb.append(dist[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
    
    static class Node implements Comparable<Node>{
        int node;
        int cost;
        
        public Node(int n, int c){ // [형태암기] !!!!!!!! 
            this.node = n;
            this.cost = c;
        }
        
        // 우선순위 큐 정렬 기준을 위해 compareTo 함수 구현
        @Override
        public int compareTo(Node n){ // [형태암기] !!!!!!! 
            return Integer.compare(this.cost, n.cost); // [형태암기] !!!!!!! 
        }
    }
    
    static void dijkstra(int start){
        boolean[] visited = new boolean[V+1];
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0; // 시작 노드는 거리 0으로 초기화
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(start, 0)); // 시작 노드 추가
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.node]) continue;
            visited[now.node] = true;
            
            for(Node next : graph[now.node]){
                if(dist[next.node] > dist[now.node]+next.cost){
                    dist[next.node] = dist[now.node]+next.cost;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }     
}