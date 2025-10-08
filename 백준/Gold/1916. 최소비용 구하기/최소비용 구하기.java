import java.io.*;
import java.util.*;

public class Main{
    static List<Node>[] graph; // [암기]
    static int start, end;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N+1]; // [암기]
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        int v, w, cost;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(w, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        dijkstra(N, start);
    }
    
    static class Node implements Comparable<Node>{
        int index;
        int cost;
        
        public Node(int i, int c){ // [형태 암기]
            this.index = i;
            this.cost = c;
        }
        
        @Override
        public int compareTo(Node n){ // [형태 암기]
            return Integer.compare(this.cost, n.cost);
        }
    }
    
    static void dijkstra(int n, int start){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0; // [잊지 말기]
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); 
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.index]) continue;
            visited[now.index] = true;
            
            for(Node next : graph[now.index]){
                if(dist[next.index] > dist[now.index]+next.cost){
                    dist[next.index] = dist[now.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index])); // [누적 비용 넣어야 함]
                }
            }
        }
        System.out.println(dist[end]);
    }
}