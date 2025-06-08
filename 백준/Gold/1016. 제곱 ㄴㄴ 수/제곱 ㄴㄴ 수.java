import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long min = Long.parseLong(st.nextToken()); // [remind]
        long max = Long.parseLong(st.nextToken());
        
        boolean[] isSquared = new boolean[(int)(max-min)+1]; // [remind]
        
        long limit = (long)Math.sqrt(max); // [remind]
        for(long i=2; i<=limit; i++){
            long square = i*i;
            long start = ((min+square-1)/square)*square; // [remind]
            
            for(long j=start; j<=max; j+=square){
                isSquared[(int)(j-min)] = true; // [remind]
            }
        }
        long result = 0;
        for(boolean flagged : isSquared){ // [remind]
            if(!flagged){
                result++;
            }
        }
        System.out.println(result); 
    }
}