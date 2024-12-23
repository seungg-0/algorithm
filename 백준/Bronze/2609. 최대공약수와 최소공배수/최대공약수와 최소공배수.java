import java.util.Scanner;

public class Main{
    // 유클리드 호제법 (최대공약수 구하기)
    static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        // 최대공약수 : A*B/최소공배수
        System.out.println(gcd(A, B));
        System.out.println(A*B/gcd(A, B));
        
    }
}