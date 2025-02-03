import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long numFive = 0;
        for (int i = 5; i <= N; i *= 5) {
            numFive += N / i;
        }
        System.out.println(numFive);
    }
}