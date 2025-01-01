import java.util.*;

public class Main{
    
    static int fibonachi(int n){
        int front1 = 1;
        int front2 = 0;
        int now = 0;
        if(n==0) return 0;
        if(n==1) return 1;
        
        for(int i=2; i<n+1; i++){
            now = front1+front2; // Fn = F(n-1)+F(n-2)
            front2 = front1;
            front1 = now;
        }
        return now;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonachi(n));
        
    }
}