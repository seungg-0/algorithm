// DFS
// 1~V에서 시작해서 DFS 했을 때 가장 거리가 먼 것 구하기
// 자료 : 연결정보 저장 / 방문처리 / 가중치 저장 

import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<int[]>[] link;
    static boolean[] visited;
    static int V;
    static int answer;
    static int farthestNode;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        V = Integer.parseInt(br.readLine());
        link = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            link[i] = new ArrayList<>();
        }
        
        int n1, n2, c;
        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            while(true){
                n2 = Integer.parseInt(st.nextToken());
                if(n2 == -1){
                    break;
                }
                c = Integer.parseInt(st.nextToken());
                link[n1].add(new int[] {n2, c});
            }
        }
        
        answer = 0;
        // 첫 번째 DFS : 임의의 노드(1)에서 가장 먼 노드 찾기 (끝 노드 찾기)
        visited = new boolean[V+1];
        visited[1] = true;
        DFS(1, 0);
        
        // 두 번째 DFS : 끝 노드에서 깊이우선탐색 진행하기
        visited = new boolean[V+1];
        visited[farthestNode] = true;
        DFS(farthestNode, 0);

        System.out.println(answer);
    }
    
    static void DFS(int n, int c){
        if(c>answer){
            answer = c;
            farthestNode = n;
        }
        for(int[] next : link[n]){
            if(!visited[next[0]]){
                visited[next[0]] = true;
                DFS(next[0], c+next[1]);
                visited[next[0]] = false;
            }
        }
    }
}