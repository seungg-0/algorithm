import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        long A = sc.nextInt();
        long B = sc.nextInt();
        long C = sc.nextInt();
        
        long ABC = A*B*C;
        
        String StrABC = String.valueOf(ABC);
        int[] countArray = new int[10];
        
        for(int i=0; i<10; i++){
            for(int j=0; j<StrABC.length(); j++){
                if(StrABC.charAt(j) == String.valueOf(i).charAt(0)) countArray[i]++;
            }
        }
        
        for(int i=0; i<10; i++){
            System.out.println(countArray[i]);
        }
        
    }
}