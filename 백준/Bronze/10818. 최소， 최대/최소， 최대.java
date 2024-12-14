import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = -2147000000;
        int min = 2147000000;
        
        for(int i=0; i<N; i++){
            int n = sc.nextInt();
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        System.out.print(min+" ");
        System.out.print(max);
        sc.close();
    }
}