import java.util.*;
import java.io.*;

// 오름차순으로 정렬, DP
public class Main{
   public static void main(String[] args)throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       int[] list = new int[N];
       
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       for(int i=0; i<N; i++){
           list[i] = Integer.parseInt(st.nextToken());
       }
       Arrays.sort(list); // 오름차순 정렬
       int result = 0;
       for(int i=N; i>0; i--){
           result += list[N-i]*i;
       }
       System.out.println(result);
   }
}