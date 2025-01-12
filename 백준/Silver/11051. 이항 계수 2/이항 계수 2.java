import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int mod = 10007;
        
        // (n+1)C(r+1) = nCr+nC(r+1)
        // nC0 = nCn = 1
        
        int[][] Dp = new int[N+1][N+1];
        for(int n=0; n<=N; n++){
            Dp[n][0] = 1;
            Dp[n][n] = 1;
        }
        
        for(int i=1; i<N; i++){
            for(int j=0; j<K; j++){
                Dp[i+1][j+1] = (Dp[i][j]%mod + Dp[i][j+1]%mod)%mod;  
            }
        }
        
        System.out.println(Dp[N][K]%mod);
        
    }
}