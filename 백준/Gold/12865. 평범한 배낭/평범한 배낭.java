// knapsack 문제 (DP문제)
// 0-1 knapsack 문제 (넣거나/안넣거나)
// case 1 : 넣으려는 아이템이 가방 무게보다 클 때
// case 2 : 넣으려는 아이템이 가방 무게보다 작거나 같을 때

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N, K, W, V;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][K+1];
        int[][] items = new int[N+1][2];
        
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            items[i][0] = W; // 인덱스 0 : 무게
            items[i][1] = V; // 인덱스 1 : 가치 
        }
        
        // DP[i][j] -> j무게에서 i까지 탐색했을 때 최대 가치
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(items[i][0]>j){ // 넣을 수 없는 경우 
                    dp[i][j] = dp[i-1][j];
                } else{ // 넣을 수 있는 경우
                    dp[i][j] = Math.max(dp[i-1][j], items[i][1]+dp[i-1][j-items[i][0]]);
                }    
            }
        }
        System.out.println(dp[N][K]);
        // System.out.println(Arrays.deepToString(dp));
    }
}
