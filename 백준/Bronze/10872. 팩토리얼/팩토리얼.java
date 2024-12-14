import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 1;
        
        for(int i=N+1; i>1; i--){
            result *= (i-1);
        }
        
        System.out.println(result);
        sc.close();
    }
}