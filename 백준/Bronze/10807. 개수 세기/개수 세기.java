import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] a;	
        a = new int[n];		
        for (int i = 0 ; i < n ; i++) {
			a[i] = sc.nextInt();		
		}
        sc.nextLine();
        int find = sc.nextInt();
        
        int cnt = 0;
        for (int i=0; i<n; i++){
            if (find == a[i]){
                cnt += 1;
            }
        }
        System.out.print(cnt);
    }
}