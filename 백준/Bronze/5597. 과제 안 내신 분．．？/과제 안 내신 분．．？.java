import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] input = new boolean[31];
        
        for(int i=0; i<28; i++){
            input[Integer.parseInt(br.readLine())] = true;
        }
        
        for(int i=1; i<31; i++){
            if(!input[i]) System.out.println(i);
        }
    }
}