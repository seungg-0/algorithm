import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[N+1]; // 누적합 
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){ // 누적합 만들기
            prefixSum[i+1] = prefixSum[i]+ Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());               
            int sum = prefixSum[end] - prefixSum[start-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}