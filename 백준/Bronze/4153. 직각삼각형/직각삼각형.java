import java.io.*;
import java.util.*;

public class Main{
    
    static String isRight(long a, long b, long c){
        long[] array = new long[3];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        Arrays.sort(array); // 오름차순 정렬
        if(Math.pow(array[2], 2) == (Math.pow(array[0], 2)+Math.pow(array[1], 2))){
            return "right\n";
        } else return "wrong\n";
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Long a = Long.parseLong(st.nextToken());
            Long b = Long.parseLong(st.nextToken());
            Long c = Long.parseLong(st.nextToken());
            if(a==0 && b==0 && c==0) break;
            sb.append(isRight(a, b, c));
        }
        System.out.println(sb);
    }
}