import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 고유번호 처음 5자리 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        for(int i=0; i<5; i++){
            sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        System.out.println(sum%10);
        
    }
}