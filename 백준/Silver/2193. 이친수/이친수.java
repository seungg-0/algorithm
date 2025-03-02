// 0으로 시작 안함
// 1이 연속으로 X
// 첫 시작 무조건 1, 현재 0일 경우 뒤에 올 수 있는 경우의 수 
// 끝이 1, 0 으로 끝나는 수의 갯수 누적, 1갯수*1 + 0갯수*2가 이친수
// 다음 수의 1 갯수 : 0의 갯수 , 0의 갯수 : 1의 갯수 + 0의 갯수
// DP
    
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N];
        
        long numZero = 0;
        long numOne = 0;
        long preNumOne = 0;
        dp[0] = 1;
        numOne++;
        if(N==1){
            System.out.println(1);
        } else{
            for(int i=1; i<N; i++){
                dp[i] = numOne+numZero*2;
                preNumOne = numOne;
                numOne = numZero;
                numZero = numOne+preNumOne;
            }
            System.out.println(dp[N-1]);
        } 
    }
}