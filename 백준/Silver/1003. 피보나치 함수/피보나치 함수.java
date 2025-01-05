import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 이중리스트 만들어서 [0갯수, 1갯수] 저장하기 
        int[][] count = new int[41][2];
        count[0][0] = 1;
        count[0][1] = 0;
        count[1][0] = 0;
        count[1][1] = 1;
        for(int i=2; i<41; i++){
            count[i][0] = count[i-1][0]+count[i-2][0];
            count[i][1] = count[i-1][1]+count[i-2][1];
        }
        
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int t = Integer.parseInt(br.readLine());
            sb.append(String.valueOf(count[t][0])).append(" ").append(String.valueOf(count[t][1])).append("\n");
        }
        System.out.println(sb);
    }
}