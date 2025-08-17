// N개의 지점, M개의 도로, W개의 웜홀
// 웜홀로 도착하면 시간 뒤로감 
// 음의 사이클 찾아내는 문제 -> 벨만 포드

// 음의 사이클이 있으면 YES, 없으면 NO 

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<TC; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            Edge[] edges = new Edge[2*M+W]; // 도로는 방향이 없고 웜홀은 방향이 있음
            for(int j=0; j<M; j++){ // 도로 정보 입력받기
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges[j] = new Edge(start, end, cost);
                edges[M+j] = new Edge(end, start, cost); // 도로는 방향이 없어서 양방향 도로 정보 입력
            } 
            for(int h=2*M; h<(2*M+W); h++){ // 웜홀 정보 입력받기
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges[h] = new Edge(start, end, -cost); // 웜홀은 방향 있어서 단방향 정보 입력
            }
            
            // 벨만 포드 최단거리 구하기
            int[] D = new int[N+1];
            Arrays.fill(D, 0); // 어떤 점에서 시작하든 음수 사이클만 찾으면 됨 (모든 정점을 시작점으로 탐색하기 위해 0으로 초기화)
            for(int h=1; h<N; h++){
                for(int j=0; j<(2*M+W); j++){
                    Edge edge = edges[j];
                    if(D[edge.start]!=Integer.MAX_VALUE && (D[edge.start]+edge.cost) < D[edge.end]){
                        D[edge.end] = D[edge.start]+edge.cost; // 갱신
                    }
                }
            }
            
            // 음의 사이클 존재하는지 확인
            boolean flag = false;
            for(int j=0; j<(2*M+W); j++){
                Edge edge = edges[j];
                if(D[edge.start]!=Integer.MAX_VALUE && (D[edge.start]+edge.cost)<D[edge.end]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
    
    static class Edge{
        int start;
        int end;
        int cost;
        public Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
