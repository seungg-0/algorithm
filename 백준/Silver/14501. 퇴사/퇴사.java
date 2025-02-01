import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 일수
        int[] T = new int[N+1]; // 작업 기간
        int[] P = new int[N+1]; // 작업 수익
        int[] dp = new int[N+2]; // 최대 금액 (index N+2는 N+1일쨰, 0으로 셋팅)
        
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());  // 해당 날의 작업 소요 기간
            P[i] = Integer.parseInt(st.nextToken());  // 해당 날의 작업 금액
        }
        
        // 나중에 들어온 일은 그때부터 할 수 있으니까 뒤부터 탐색해야 함.
        // 그떄 일을 하는것과 하지 않는것 중 어떤것이 최선인지
        // 앞쪽부터 탐색하면 선택지가 하나 뿐이기 때문
        for(int i=N; i>=1; i--){
            // 일을 하지 않는 경우
            dp[i] = Math.max(dp[i], dp[i+1]);
            
            // 일을 하는 경우 
            if(i+T[i]<=N+1){
                dp[i] = Math.max(dp[i], P[i]+dp[i+T[i]]);
            }
        }
        System.out.println(dp[1]);
    }
}