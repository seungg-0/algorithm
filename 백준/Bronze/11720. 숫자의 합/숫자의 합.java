import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String sNum =br.readLine(); // 문자열 입력받아서
        char[] cNum = sNum.toCharArray(); // char 배열로 저장
        int sum = 0;
        for(int i = 0; i < cNum.length; i++){
            sum += cNum[i] - '0'; //cNum[i]를 정수형으로 변환
        }
        System.out.println(sum);
    }
}