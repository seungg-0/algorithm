import java.util.Scanner;

public class Main{
    // 유클리드 호제법 (최대공약수 구하기)
    public static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스 입력
        int T = sc.nextInt();
        
        for(int i = 0 ; i<T ; i++){
            // A, B 입력
            int A = sc.nextInt();
            int B = sc.nextInt();
            // 최소공배수 : (num1 * num2) / 최대공약수
            int result = A*B/gcd(A, B);
            System.out.println(result);
        }
        sc.close();
    }
}
