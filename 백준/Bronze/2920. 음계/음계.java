import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arrays = new int[8];
        for(int i=0; i<8; i++){
            arrays[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean asc = true;
        boolean desc = true;
        for(int i=1; i<8; i++){
            if(arrays[i]>arrays[i-1]) desc = false;
            if(arrays[i]<arrays[i-1]) asc = false;
        }
        if(asc) System.out.println("ascending");
        else if(desc) System.out.println("descending");
        else System.out.println("mixed");
    }
}