import java.util.*;

public class Main{
    
    static int isLeap(int n){
        if((n%4) != 0) return 0;
        else{// 4의 배수이면서
            //100의 배수이고 400의 배수가 아닐떄
            if(((n%100)==0)&&((n%400)!=0)) return 0;
            else return 1;
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(isLeap(year));
    }
}