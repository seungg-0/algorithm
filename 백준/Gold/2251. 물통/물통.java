// 모든 경우의 수를 확인해야 함 
// 방문을 2차원 배열로 (A, B) (A, B)가 정해지면 C는 저절로 정해지기 때문에 두개만 해주면 됨

import java.util.*;
import java.io.*;

public class Main{
    static boolean[][] visited;
    static boolean[] answer;
    static int[] capacity;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        capacity = new int[3];
        for(int i=0; i<3; i++){
            capacity[i] = Integer.parseInt(st.nextToken());
        }
        
        visited = new boolean[201][201]; // 각각 최댓값 200
        answer = new boolean[201];
        DFS(0, 0, capacity[2]);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=capacity[2]; i++){
            if(answer[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void DFS(int a, int b, int c){
        if(visited[a][b]) return;
        visited[a][b] = true;
        if(a==0) answer[c] = true;
 
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i!=j){
                    int[] next = {a, b, c};
                    int pour = Math.min(next[i], capacity[j]-next[j]); // j에 i를 붓는 상황
                    next[i] -= pour;
                    next[j] += pour;
                    DFS(next[0], next[1], next[2]);
                }
            }
        }
    }
}