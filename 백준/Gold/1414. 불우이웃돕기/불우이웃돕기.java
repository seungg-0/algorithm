// 네트워크의 모든 정점을 최소 비용으로 연결 -> 크루스칼 알고리즘

import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int totalCost;
    
    public static void union(int[] parent, int x, int y){
        int px = find(parent, x);
        int py = find(parent, y);
        if(px < py){ // 부모 합치기 
            parent[py] = px;
        } else{
            parent[px] = py;
        }
    }
    
    public static int find(int[] parent, int x){
        if(parent[x] == x){
            return x;
        } else{
            return find(parent, parent[x]);
        }
    }
    
    public static void kruskal(int[][] graph, int[] parent){
        int cost = 0;
        int count = 0;
        for(int i=0; i<N*N; i++){
            if(find(parent, graph[i][0]) != find(parent, graph[i][1])){ // 부모가 다를 경우 
                union(parent, graph[i][0], graph[i][1]); // 부모 합치기
                cost += graph[i][2]; // 비용 추가 
                count++;
            }
        }
        
        if(count < N-1){ // MST에선 간선 수가 N-1이면 완료
            System.out.println(-1); // 모든 컴퓨터를 연결할 수 없는 경우
        }else{
            System.out.println(totalCost-cost);
        }
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[N*N][3]; // 나가는 노드, 들어오는 노드, 가중치
        int[] parent = new int[N+1]; 
     
        for(int i=1; i<=N; i++){ // 부모는 자기 자신으로 초기화
            parent[i] = i;
        }
        
        totalCost = 0;
        for(int i=0; i<N; i++){ // 나가는 노드, 들어오는 노드, 가중치 정보 입력받기
            String s = br.readLine();
            char c;
            for(int j=0; j<N; j++){
                c = s.charAt(j); // [암기]
                if(c!='0'){ // 랜선으로 연결되어 있다면
                    graph[j+i*N][0] = i+1; // 나가는 노드
                    graph[j+i*N][1] = j+1; // 들어오는 노드
                    if(c >= 'a' && c <= 'z'){ // [암기] 'a' → 'z' : 97 → 122
                        graph[j+i*N][2] = c - 'a' + 1; // [암기]
                        totalCost += graph[j+i*N][2];
                        
                    } else if (c >= 'A' && c <= 'Z'){ // [암기] 'A' → 'Z' : 65 → 90
                         graph[j+i*N][2] = c - 'A' + 27; // [암기]
                         totalCost += graph[j+i*N][2];
                    }
                }
            }
        }
        Arrays.sort(graph, (o1, o2) -> o1[2]-o2[2]); // 비용 오름차순으로 정렬
        kruskal(graph, parent);
        
    }
}