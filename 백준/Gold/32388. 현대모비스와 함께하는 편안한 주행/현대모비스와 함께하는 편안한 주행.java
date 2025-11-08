// 최단거리 -> 다익스트라 !! 

import java.io.*;
import java.util.*;

public class Main{
    static int a, b;
    static int n;
    static int[][] nxny;
    static ArrayList<Node>[] graph;
    
    public static void main(String[] arge)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a = Integer.parseInt(st.nextToken()); // 도착 x좌표
        b = Integer.parseInt(st.nextToken()); // 도착 y좌표
        n = Integer.parseInt(br.readLine()); // 간판의 수
        nxny = new int[n+2][2];
        
        nxny[0][0] = 0;
        nxny[0][1] = 0;
        nxny[n+1][0] = a;
        nxny[n+1][1] = b;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            nxny[i][0] = Integer.parseInt(st.nextToken()); // 간판 x좌표 입력받기
            nxny[i][1] = Integer.parseInt(st.nextToken()); // 간판 y좌표 입력받기
        }
        
        graph = new ArrayList[n+2]; // 간판 갯수 + 시작, 도착 
        for(int i=0; i<n+2; i++){
            graph[i] = new ArrayList<>();
        }
        // 연결 정보 저장 
        for(int i=0; i<n+2; i++){
            for(int j=0; j<n+2; j++){
                if(i!=j){
                    if((i==0 || i==n+1) && (j==0 || j==n+1)){ // 간판 0
                        double d = Math.sqrt(Math.pow(nxny[i][0]-nxny[j][0], 2)
                                             +Math.pow(nxny[i][1]-nxny[j][1], 2));
                        graph[i].add(new Node(j, d));
                        graph[j].add(new Node(i, d));
                    } else if (i==0 || i==n+1 || j== 0 || j==n+1){ // 간판 1
                        double d = Math.max(0.0, Math.sqrt(Math.pow(nxny[i][0]-nxny[j][0], 2)
                                             +Math.pow(nxny[i][1]-nxny[j][1], 2))-1);
                        graph[i].add(new Node(j, d));
                        graph[j].add(new Node(i, d));
                    } else{ // 간판 2
                        double d = Math.max(0.0, Math.sqrt(Math.pow(nxny[i][0]-nxny[j][0], 2)
                                                           +Math.pow(nxny[i][1]-nxny[j][1], 2))-2);
                        graph[i].add(new Node(j, d));
                        graph[j].add(new Node(i, d));
                    }
                }
            }
        }
        dijkstra();
    }
    
    // 가중치가 있는 그래프를 담기 위한 별도의 클래스 구현 (가중치 : 거리)
    static class Node implements Comparable<Node>{
        int index;
        double dist;
        
        public Node(int i, double d){
            this.index = i;
            this.dist = d;
        }
        
        // 우선순위 큐 정렬 기준을 위해 compareTo 함수 구현
        @Override
        public int compareTo(Node n){
            return Double.compare(this.dist, n.dist);
        }
    }
    
    static void dijkstra(){
        boolean[] visited = new boolean[n+2];
        double[] distance = new double[n+2];
        Arrays.fill(distance, Double.POSITIVE_INFINITY);
        distance[0] = 0; // 출발은 거리 0
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visited[now.index]) continue;
            visited[now.index] = true;
            for(Node next : graph[now.index]){
                if(distance[next.index] > distance[now.index]+next.dist){
                    distance[next.index] = distance[now.index]+next.dist;
                    pq.offer(new Node(next.index, distance[next.index]));
                }
            }
        }
        System.out.printf("%.10f\n", distance[n+1]);
    }
}
        
        
        
        