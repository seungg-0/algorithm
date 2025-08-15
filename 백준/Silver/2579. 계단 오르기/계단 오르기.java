// 연속 세칸 x
// 한칸 혹은 두칸 
// 마지막 밟아야 함 

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numStairs = Integer.parseInt(br.readLine()); // 계단 수 입력받기
        int[] stairScore = new int[numStairs+1]; // 계단 점수 저장할 배열
        int[] dp = new int[numStairs+1];
        
        for(int i=1; i<=numStairs; i++){ // 계단 점수 입력받기 [범위 주의]
            stairScore[i] = Integer.parseInt(br.readLine());
        }

        // DP 
        // 연속세칸 아닌지 확인, 마지막칸 밟았는지 확인
        // 다음칸, 다다음칸 중 합계 큰거 선택
        
        dp[1] = stairScore[1]; // 첫 번째 계단에서의 최적해 선택지는 하나 ! 
        
        if(numStairs>=2){ // 두 번째 계단에서의 최선
            dp[2] = Math.max(stairScore[1]+stairScore[2], stairScore[2]);
        }
        
        for(int i=3; i<=numStairs; i++){
            dp[i] = Math.max(dp[i-3]+stairScore[i-1]+stairScore[i], dp[i-2]+stairScore[i]);
        }
        
        System.out.println(dp[numStairs]);
        
    }
}