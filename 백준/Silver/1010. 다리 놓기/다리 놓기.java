import java.io.*;
import java.util.*;

// 다이나믹 프로그래밍 (조합을 DP로)
// (n+1)C(r+1) = nCr + nC(r+1)
// nC0 = nCn = 1
public class Main{
    static long[][]D;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        D = new long[31][31];
        for(int i=0; i<30; i++){
            D[i][0] = 1;
            D[i][i] = 1;
            for(int j=0; j<i; j++){
                D[i+1][j+1] = D[i][j]+D[i][j+1];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(D[n][r]).append("\n");
        }
        System.out.println(sb);
    }
}