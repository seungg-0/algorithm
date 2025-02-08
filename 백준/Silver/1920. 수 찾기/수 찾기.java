import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> Amap = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            Amap.put(Integer.parseInt(st.nextToken()), 1); 
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            if(Amap.containsKey(Integer.parseInt(st.nextToken()))){
                sb.append(1).append("\n");
            } else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}