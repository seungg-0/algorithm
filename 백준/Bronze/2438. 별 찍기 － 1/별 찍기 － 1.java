import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // N 입력받기
        
        StringBuilder sb = new StringBuilder();
        // 별 출력
        for(int i=0; i<N; i++){
            for(int j=0; j<i+1; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}