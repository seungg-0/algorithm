import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] list = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        System.out.println(list[K-1]);
    }
}