import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int max = 0;
        int idx = 0;
        for (int i=1; i<10; i++){
            a[i] = Integer.parseInt(sc.nextLine());
            if (a[i] > max){
                max = a[i];
                idx = i;
            }
        }
        System.out.println(max);
        System.out.print(idx);
    }
}