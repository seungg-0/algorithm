import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        Long[][] Dp = new Long[101][10];
        Long mod = 1_000_000_000L;
        
        // N자릿수 0으로 시작하는 수 : (N-1)자릿수 1로 시작하는 수와 같음
        // N자릿수 9로 시작하는 수 : (N-1)자릿수 8로 시작하는 수와 같음 
        // N자릿수 (2~8(i))으로 시작하는 수 : (N-1)자릿수 i-1 + (N-1)자릿수 i+1
        
        for(int i=0; i<10; i++){
            Dp[1][i] = 1L; // 길이 1인 경우의 경우의수 : 1
        }
        
        int N = Integer.parseInt(br.readLine());
        for(int n=2; n<=N; n++){
            for(int i=0; i<10; i++){
                if(i==0) Dp[n][0] = Dp[n-1][1]%mod; // N자릿수 0으로시작 = N-1자릿수 1로 시작
                else if(i==9) Dp[n][9] = Dp[n-1][8]%mod; // N자릿수 9로시작 = N-1자릿수 8로 시작
                else{ // 2~8
                    Dp[n][i] = (Dp[n-1][i-1]+Dp[n-1][i+1])%mod; // N자릿수 (2~8(i))으로 시작하는 수 : (N-1)자릿수 i-1 + (N-1)자릿수 i+1
                }
            }
        }
       
        long result = 0L;
        for(int i=1; i<10; i++){
            result += Dp[N][i];
            result %= mod;
        }
        System.out.println(result%mod);
    }
}