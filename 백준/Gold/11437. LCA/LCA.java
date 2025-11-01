// '트리'의 특성을 생각하고 문제 접근을 해야 함
// 1. 1번 루트노드를 기준으로 DFS탐색을 하면서 각 노드의 트리의 높이(h)와 부모 노드(parent)를 저장해준다.
// 2. LCA(a, b)가 주어진다.
//   1. 해당 두 노드의 h를 일정하게 맞춘다 (a의 높이 == b의 높이 )
//   2. 각 부모노드가 일치할 때 까지 비교하며 구한다. (최대 LCA는 루트노드 1)

import java.util.*;
import java.io.*;

public class Main{
    static int[] depth, parent;
    static ArrayList<Integer>[] link;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int c1, c2;
        depth = new int[N+1];
        parent = new int[N+1];
        link = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            link[i] = new ArrayList<>();
        }
        
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            c1 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            link[c1].add(c2);
            link[c2].add(c1);
        }
        DFS(1, 1, 0); // 1번째 노드, 차수 1, 부모 0
        
        int M = Integer.parseInt(br.readLine());
        int a, b;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void DFS(int n, int d, int p){
        depth[n] = d;
        parent[n] = p;
        
        for(int next : link[n]){
            if(next != p){
                DFS(next, d+1, n); // 차수, 부모 정보 저장
            }
        }
    }
    
    static int LCA(int a, int b){
        int ah = depth[a];
        int bh = depth[b];
        
        while(ah>bh){
            ah -= 1;
            a = parent[a];
        }
        while(ah<bh){
            bh -= 1;
            b = parent[b];
        }

        while(a!=b){
            ah -= 1;
            a = parent[a];
            bh -= 1;
            b = parent[b];
        }
        return a;
    }
}