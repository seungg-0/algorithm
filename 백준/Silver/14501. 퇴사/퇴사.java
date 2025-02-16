import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        // 입력값을 위한 초기 위한 변수 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+2]; // 마지막 일을 안하는 경우를 대비해서 N+1일까지 
        
        for(int i=1; i<=N; i++){ // 시간과 페이 입력받기
            st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=N; i>=1; i--){ // DP탐색 시작. 마지막 날짜부터 탐색 (처음부터 탐색하면 선택지를 모두 고려할 수 없음. 미래의 일은 아직 들어오지 않았기 때문에)
            // 일을 하지 않는 경우
            dp[i] = dp[i+1]; // 다음날 버는 돈으로 설정
            
            // 일을 하는 경우
            if((i+T[i])<=N+1){
                dp[i] = Math.max(dp[i], P[i]+dp[i+T[i]]); // 일을 하는 경우엔 벌 수 있는 돈이 P[i]만큼, 플러스 기간 후로부터 일 할 때의 돈
            }
        }
        System.out.println(dp[1]);
    }
}