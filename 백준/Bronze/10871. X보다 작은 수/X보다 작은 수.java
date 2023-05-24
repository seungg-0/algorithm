import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        sc.nextLine();
        
        int[] a = new int[n];  
        for (int i=0; i<n; i++){
            a[i] = sc.nextInt();
            if (a[i] < num){
                System.out.print(a[i]);
                System.out.print(' ');
            }
        }
        
    }
}