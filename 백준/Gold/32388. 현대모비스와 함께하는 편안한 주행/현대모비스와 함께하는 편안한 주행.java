// 음수의 가중치가 없고, 점들간 최단거리 > 다익스트라 !! 
// 1. 거리 저장할 자료형 int[] / 2. 연결정보 저장할 자료형 ArrayList<Node>[] linked/ 3. 입력정보 저장할 자료형 int[][] / 4. 다익스트라 계산 자료형 PriorityQueue / 5. 다익스트라 내 "방문처리" int[] visited
// Node 클래스
// 다익스트라 내부 방문처리 유의하기 ! 

import java.util.*;
import java.io.*;

public class Main{
    static int[][] graph;
    static ArrayList<Node>[] linked;
    static double[] distance;
    static boolean[] visited;
    static int a, b, N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 도착지점 입력받기
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        
        graph = new int[N+2][2]; // 간판 N개랑 출발/도착지 해서 +2
        // 출발지 및 도착지 좌표 넣어주기
        graph[0][0] = 0;
        graph[0][1] = 0;
        graph[N+1][0] = a;
        graph[N+1][1] = b;
        
        for(int i=1; i<=N; i++){ // 간판 정보 저장해주기
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
        }
        
        linked = new ArrayList[N+2];
        for(int i=0; i<N+2; i++){// [주의] ArrayList배열은 이거 빼먹으면 안됨
            linked[i] = new ArrayList<>();
        }
        
        // 점들간의 거리 정보 저장해주기 (연결 정보 저장) 거리가 가중치임.
        for(int i=0; i<N+2; i++){
            for(int j=0; j<N+2; j++){
                if(i==j){
                    continue;
                } else{
                    if((i==0 || i==N+1)&&(j==0 || j==N+1)){ // 간판 0개 
                        double d = Math.sqrt(Math.pow(graph[i][0]-graph[j][0], 2)
                                           + Math.pow(graph[i][1]-graph[j][1], 2));
                        // 연결 정보 저장
                        linked[i].add(new Node(j, d));
                        linked[j].add(new Node(i, d)); 
                    } else if (i==0 || i==N+1 || j==0 || j==N+1){ // 간판 1개 
                        // 음수 저장되면 안됨
                        double d = Math.max(0.0, Math.sqrt(Math.pow(graph[i][0]-graph[j][0], 2)
                                           + Math.pow(graph[i][1]-graph[j][1], 2))-1);
                        // 연결 정보 저장
                        linked[i].add(new Node(j, d));
                        linked[j].add(new Node(i, d)); 
                    } else { // 간판 두개
                        double d = Math.max(0.0, Math.sqrt(Math.pow(graph[i][0]-graph[j][0], 2)
                                           + Math.pow(graph[i][1]-graph[j][1], 2))-2);
                        // 연결 정보 저장
                        linked[i].add(new Node(j, d));
                        linked[j].add(new Node(i, d)); 
                    }
                }
            }
        }
        dijkstra(0, 0);
        System.out.printf("%.10f",distance[N+1]);
        
    }
    
    // [암기] !!!!!!!!!!!!!!!!!!!!!!!!!
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
    
   static void dijkstra(int x, int y){
       visited = new boolean[N+2];
       distance = new double[N+2]; // 거리 저장할 자료형 하나 필요함
       PriorityQueue<Node> pq = new PriorityQueue<>();
       Arrays.fill(distance, Double.POSITIVE_INFINITY);
       pq.offer(new Node(0, 0));
       distance[0] = 0.0;
       
       // distance를 업데이트 시켜주기
       while(!pq.isEmpty()){
           Node now = pq.poll();
           
           // 방문처리 위치 유의 !!!!!!!!!!!!!!
           if(visited[now.index]) continue;
           visited[now.index] = true;
           for(Node next : linked[now.index]){ // 연결된거 하나씩 거리 업데이트
               if(distance[next.index]>distance[now.index]+next.dist){// 업데이트 필요 (시작~다음거리>시작~현재거리+현재~다음거리)
                   distance[next.index] = distance[now.index]+next.dist;
                   pq.offer(new Node(next.index, distance[next.index]));
               }
           }
       }
   }
}