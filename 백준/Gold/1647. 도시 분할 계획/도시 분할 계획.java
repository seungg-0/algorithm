// N개의 집과, 집 연결하는 M개의 길, 집 사이 경로 항상 존재 
// 마을 내의 집들만 연결 돼있으면 됨
// 두개의 마을로 분리, 연결 비용 최소화 
// [방법] 하나로 연결하는데, 길이가 가장 긴 것 삭제하면 됨.
// [크루스칼 알고리즘] 1. 간선 비용 오름차순으로 정렬 2. 유니온 파인드로 부모 다를 경우 비용 추가
// 위 과정에서 비용 가장 큰 것 구하고, 마지막에 빼주면 됨
// 크루스칼 알고리즘은 최소비용으로 순환 없이 모든 노드 연결하는 것.

import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] linkedInfo;
    static int[] parent;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int maxCost = 0;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        linkedInfo = new int[M][3]; // 간선넘버, 노드1, 노드2, 비용
        parent = new int[N+1];
        
        for(int i=0; i<M; i++){ // 노드1 노드2 비용 입력받기
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            linkedInfo[i][0] = n1;
            linkedInfo[i][1] = n2;
            linkedInfo[i][2] = cost;
        }
        
        Arrays.sort(linkedInfo, (n1, n2) -> n1[2]-n2[2]); // 비용 오름차순 정렬
        
        // 부모 초기화
        for(int i=1; i<=N; i++){
            parent[i] = i; // 자기자신으로 부모 초기값 설정
        }
        
        for(int i=0; i<M; i++){ // 비용 적은 것부터 하나씩 꺼내서 비용 구하기
            int n1 = linkedInfo[i][0];
            int n2 = linkedInfo[i][1];
            int cost = linkedInfo[i][2];
            if(find(n1)!=find(n2)){ // 부모가 다르면
                union(n1, n2); // 부모 합쳐주기
                answer += cost; // 도시 연결
                maxCost = Math.max(maxCost, cost); // 이은 간선 중 최댓값 찾기
            }
        }
        
        System.out.println(answer-maxCost); // 마을 가장 비용 큰 간선으로 분리하여 총 비용 출력
    }
    
    public static void union(int x, int y){
        int px = find(x); // x의 부모 
        int py = find(y); // y의 부모
        
        if(px < py){ // 부모 합쳐주기
            parent[py] = px;
        } else{
            parent[px] = py;
        }
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x; // 아직 초기화 전이면 바로 리턴
        } else {
            return find(parent[x]);
        }
    }
}


