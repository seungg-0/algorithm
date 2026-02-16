// 임의의 두 정점 반드시 통과해야 함 (1번 정점에서 N번 정점으로 이동)
// 갔던 곳 다시 갈 수 있음 
// indexOutofBounds 에러에 유의하기 !!!!!!!!!!!!!!!!


// 정점간 최단거리 -> 다익스트라

import java.util.*;
import java.io.*;

public class Main{
    static int N, E;
    static double[] distance;
    static ArrayList<Node>[] linked;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        linked = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            linked[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double d = Integer.parseInt(st.nextToken());
            // 연결정보 저장
            linked[a].add(new Node(b, d));
            linked[b].add(new Node(a, d));
        }
        
        st = new StringTokenizer(br.readLine());
        int station1 = Integer.parseInt(st.nextToken());
        int station2 = Integer.parseInt(st.nextToken());
        double[] dist1 = dijkstra(1, 0);
        double[] dist2 = dijkstra(station1, 0);
        double[] dist3 = dijkstra(station2, 0);
        if((dist1[station1] == Double.POSITIVE_INFINITY || 
            dist2[station2] == Double.POSITIVE_INFINITY ||
            dist3[N] == Double.POSITIVE_INFINITY || 
            dist1[station2] == Double.POSITIVE_INFINITY || 
            dist3[station1] == Double.POSITIVE_INFINITY ||
            dist2[N] == Double.POSITIVE_INFINITY)){
            System.out.println(-1);
        }else{
            System.out.println((int)Math.min((dist1[station1]+dist2[station2]+dist3[N])
                          ,(dist1[station2]+dist3[station1]+dist2[N])));
        }
        
        
    }
    
    static class Node implements Comparable<Node>{
        int index;
        double dist;
        
        public Node(int i, double d){
            this.index = i;
            this.dist = d;
        }
        
        @Override
        public int compareTo(Node n){
            return Double.compare(this.dist, n.dist);
        }
    }
    
    static double[] dijkstra(int a, double b){
        boolean[] visited = new boolean[N+1];
        double[] distance = new double[N+1];
        Arrays.fill(distance, Double.POSITIVE_INFINITY);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(a, b));
        distance[a] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.index]) continue;
            visited[now.index] = true;
            for(Node next : linked[now.index]){
                if(distance[next.index]>distance[now.index]+next.dist){
                    distance[next.index] = distance[now.index]+next.dist;
                    pq.add(new Node(next.index, distance[next.index]));
                }
            }
        }
        return distance;
    }
}
