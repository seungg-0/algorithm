import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();
        Arrays.sort(N);
        int len = N.length;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            sb.append(N[len-i-1]);
        }
        System.out.println(sb);
    }
}