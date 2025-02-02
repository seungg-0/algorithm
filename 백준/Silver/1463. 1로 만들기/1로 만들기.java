// 연산을 사용하는 횟수의 최솟값 출력 
// 다이나믹 프로그래밍 문제를 풀 때는 Math.min() / Math.max() 함수를 떠올려보기

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1]; // 값은 연산 횟수를 의미함
        
        dp[1] = 0; // N이 1이라면 연산횟수는 0
        
        for(int i=2; i<=N; i++){ // 그떄그때의 최소의 연산횟수 저장하기 
            dp[i] = dp[i-1]+1; // dp[i-1] : 1을 빼는 연산, +1 : 횟수 증가시키기
            if(i%2==0){ // 2으로 나누어 떨어진다면
                dp[i] = Math.min(dp[i], dp[i/2]+1); // 1을 빼는 것과, 2으로 나누어버리는 것 중에 어떤게 최선인지
            } if(i%3==0){
                dp[i] = Math.min(dp[i], dp[i/3]+1); // 1을 빼는 것과, 3로 나누어버리는 것 중 어떤게 최선인지
            }
        }
        System.out.println(dp[N]);
    }
}