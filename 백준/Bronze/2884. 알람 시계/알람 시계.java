import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        H += 24; //24 더해주고, 최종 시간 산출시 24로 나눈값 사용
        StringBuilder sb = new StringBuilder();
        if((M+60-45)>59){
            sb.append(H%24).append(" ").append(M-45);
        }else{
            sb.append((H-1)%24).append(" ").append((M+60-45));
        }
        System.out.println(sb);
    }
}