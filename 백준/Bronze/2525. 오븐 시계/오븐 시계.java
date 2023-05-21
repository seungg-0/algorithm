import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String c = sc.nextLine();
        int cook = Integer.parseInt(c);
        
        int totalH = h+(m+cook)/60;
        int totalM = (m+cook)%60;
        
        System.out.print(totalH%24);
        System.out.print(' ');
        System.out.print(totalM);
        
 
    }
}